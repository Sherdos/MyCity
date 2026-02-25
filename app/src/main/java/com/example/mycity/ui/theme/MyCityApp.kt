package com.example.mycity.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.*
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.window.core.layout.WindowWidthSizeClass

import com.example.mycity.ui.state.MyCityViewModel
import com.example.mycity.ui.theme.navigation.Destinations
import com.example.mycity.ui.theme.screens.CategoryScreen
import com.example.mycity.ui.theme.screens.PlaceDetailsScreen
import com.example.mycity.ui.theme.screens.PlacesScreen


@Composable
fun MyCityApp(vm: MyCityViewModel = viewModel()) {
    MaterialTheme {
        val ui by vm.uiState.collectAsState()
        val adaptiveInfo = currentWindowAdaptiveInfo()
        val widthClass = adaptiveInfo.windowSizeClass.windowWidthSizeClass

        if (widthClass == WindowWidthSizeClass.EXPANDED) {
            // Two-pane: list + detail
            TwoPaneMyCity(uiState = ui, vm = vm)
        } else {
            // Phone / compact: 3 screen navigation
            SinglePaneMyCity(uiState = ui, vm = vm)
        }
    }
}

@Composable
private fun SinglePaneMyCity(
    uiState: com.example.mycity.ui.theme.state.MyCityUiState,
    vm: MyCityViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.Categories
    ) {
        composable(Destinations.Categories) {
            CategoryScreen(
                title = uiState.appTitle,
                categories = uiState.categories,
                onCategoryClick = { cat ->
                    vm.onCategorySelected(cat.id)
                    navController.navigate("${Destinations.Places}/${cat.id}")
                }
            )
        }

        composable(
            route = "${Destinations.Places}/{${Destinations.ArgCategoryId}}",
            arguments = listOf(navArgument(Destinations.ArgCategoryId) { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString(Destinations.ArgCategoryId)!!
            val categoryTitle = uiState.categories.firstOrNull { it.id == categoryId }?.title ?: "Places"

            PlacesScreen(
                categoryTitle = categoryTitle,
                places = uiState.placesInSelectedCategory,
                onBack = { navController.popBackStack() },
                onPlaceClick = { place ->
                    vm.onPlaceSelected(place.id)
                    navController.navigate("${Destinations.Details}/${place.id}")
                }
            )
        }

        composable(
            route = "${Destinations.Details}/{${Destinations.ArgPlaceId}}",
            arguments = listOf(navArgument(Destinations.ArgPlaceId) { type = NavType.StringType })
        ) {
            PlaceDetailsScreen(
                place = uiState.selectedPlace,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
private fun TwoPaneMyCity(
    uiState: com.example.mycity.ui.theme.state.MyCityUiState,
    vm: MyCityViewModel
) {
    // Adaptive list/detail scaffold
    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()

    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            // Left pane: Categories OR Places depending on selection
            if (uiState.selectedCategoryId == null) {
                CategoryScreen(
                    title = uiState.appTitle,
                    categories = uiState.categories,
                    onCategoryClick = { cat ->
                        vm.onCategorySelected(cat.id)
                        navigator.navigateTo(ListDetailPaneScaffoldRole.List)
                    }
                )
            } else {
                val categoryTitle = uiState.categories
                    .firstOrNull { it.id == uiState.selectedCategoryId }?.title ?: "Places"

                PlacesScreen(
                    categoryTitle = categoryTitle,
                    places = uiState.placesInSelectedCategory,
                    onBack = { vm.clearSelection() },
                    onPlaceClick = { place ->
                        vm.onPlaceSelected(place.id)
                        navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
                    }
                )
            }
        },
        detailPane = {
            // Right pane: Details
            PlaceDetailsScreen(
                place = uiState.selectedPlace,
                onBack = { /* in two-pane, back can just clear selection */ vm.onPlaceSelected("") }
            )
        }
    )
}
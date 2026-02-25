package com.example.mycity.ui.theme.state

import com.example.mycity.models.Category
import com.example.mycity.models.Place


data class MyCityUiState(
    val appTitle: String = "My Bishkek",
    val categories: List<Category> = emptyList(),
    val selectedCategoryId: String? = null,
    val placesInSelectedCategory: List<Place> = emptyList(),
    val selectedPlaceId: String? = null,
    val selectedPlace: Place? = null
)
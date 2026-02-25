package com.example.mycity.ui.state

import androidx.lifecycle.ViewModel
import com.example.mycity.data.CityRepository
import com.example.mycity.ui.theme.state.MyCityUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel(
    private val repo: CityRepository = CityRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        MyCityUiState(
            categories = repo.categories
        )
    )
    val uiState: StateFlow<MyCityUiState> = _uiState

    fun onCategorySelected(categoryId: String) {
        val places = repo.getPlacesByCategory(categoryId)
        _uiState.update {
            it.copy(
                selectedCategoryId = categoryId,
                placesInSelectedCategory = places,
                selectedPlaceId = null,
                selectedPlace = null
            )
        }
    }

    fun onPlaceSelected(placeId: String) {
        val place = repo.findPlace(placeId)
        _uiState.update {
            it.copy(
                selectedPlaceId = placeId,
                selectedPlace = place
            )
        }
    }

    fun clearSelection() {
        _uiState.update {
            it.copy(
                selectedCategoryId = null,
                placesInSelectedCategory = emptyList(),
                selectedPlaceId = null,
                selectedPlace = null
            )
        }
    }
}
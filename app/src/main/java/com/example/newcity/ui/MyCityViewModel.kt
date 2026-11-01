package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState(categories = LocalDataSource.categories))
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun selectCategory(categoryId: Int) {
        val category = LocalDataSource.categories.find { it.id == categoryId }
        _uiState.update {
            it.copy(
                selectedCategory = category,
                places = LocalDataSource.getPlacesForCategory(categoryId)
            )
        }
    }

    fun selectPlace(placeId: Int) {
        val place = LocalDataSource.getPlaceById(placeId)
        _uiState.update { it.copy(selectedPlace = place) }
    }
}
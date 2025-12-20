package com.example.compose.jetchat.ui.categories

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoriesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesUiState())
    val uiState: StateFlow<CategoriesUiState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        _uiState.value = CategoriesUiState(
            categories = listOf(
                CategoryUiModel(1, "Food"),
                CategoryUiModel(2, "Transport"),
                CategoryUiModel(3, "Bills")
            )
        )
    }
}

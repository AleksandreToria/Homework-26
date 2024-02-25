package com.example.homework26.presentation.event

sealed class HomeEvent {
    data object FetchCategories : HomeEvent()
    data class FetchCategoryById(val title: String) : HomeEvent()
    data object ResetErrorMessage : HomeEvent()
}
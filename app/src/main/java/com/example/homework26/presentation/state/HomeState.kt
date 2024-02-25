package com.example.homework26.presentation.state

import com.example.homework26.presentation.model.Categories

data class HomeState(
    val isLoading: Boolean = false,
    val categories: List<Categories>? = null,
    val errorMessage: String? = null
)

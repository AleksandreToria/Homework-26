package com.example.homework26.domain.usecase

import javax.inject.Inject

data class CategoryUseCase @Inject constructor(
    val getCategoriesUseCase: GetCategoriesUseCase,
    val getCategoriesByIdUseCase: GetCategoriesByIdUseCase
)

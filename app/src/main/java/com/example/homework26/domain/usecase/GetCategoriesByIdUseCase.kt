package com.example.homework26.domain.usecase

import com.example.homework26.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoriesByIdUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(title: String) = categoryRepository.getCategoriesByTitle(title)
}
package com.example.homework26.data.repository

import com.example.homework26.data.common.HandleResponse
import com.example.homework26.data.common.Resource
import com.example.homework26.data.mapper.base.asResource
import com.example.homework26.data.mapper.category.toDomain
import com.example.homework26.data.service.CategoryService
import com.example.homework26.domain.model.GetCategories
import com.example.homework26.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryService: CategoryService,
    private val handleResponse: HandleResponse
) : CategoryRepository {
    override suspend fun getCategories(): Flow<Resource<List<GetCategories>>> {
        return handleResponse.apiCall {
            categoryService.getCategories()
        }.asResource { it ->
            it.map {
                it.toDomain()
            }
        }
    }

    override suspend fun getCategoriesByTitle(title: String): Flow<Resource<List<GetCategories>>> {
        return handleResponse.apiCall {
            categoryService.getCategories(title)
        }.asResource { it ->
            it.map {
                it.toDomain()
            }
        }
    }
}
package com.example.homework26.domain.repository

import com.example.homework26.data.common.Resource
import com.example.homework26.domain.model.GetCategories
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<Resource<List<GetCategories>>>
    suspend fun getCategoriesByTitle(title: String): Flow<Resource<List<GetCategories>>>
}
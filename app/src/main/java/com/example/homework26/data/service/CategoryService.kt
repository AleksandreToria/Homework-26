package com.example.homework26.data.service

import com.example.homework26.data.model.CategoryDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryService {
    @GET("6f722f19-3297-4edd-a249-fe765e8104db")
    suspend fun getCategories(@Query("search") title: String? = null): Response<List<CategoryDto>>
}
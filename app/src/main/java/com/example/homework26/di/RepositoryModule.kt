package com.example.homework26.di

import com.example.homework26.data.common.HandleResponse
import com.example.homework26.data.repository.CategoryRepositoryImpl
import com.example.homework26.data.service.CategoryService
import com.example.homework26.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideStoryRepository(
        categoryService: CategoryService,
        handleResponse: HandleResponse
    ): CategoryRepository {
        return CategoryRepositoryImpl(
            categoryService = categoryService,
            handleResponse = handleResponse
        )
    }
}
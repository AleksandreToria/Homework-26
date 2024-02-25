package com.example.homework26.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework26.data.common.Resource
import com.example.homework26.domain.usecase.CategoryUseCase
import com.example.homework26.presentation.event.HomeEvent
import com.example.homework26.presentation.mapper.toPresenter
import com.example.homework26.presentation.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val categoriesUseCase: CategoryUseCase
) : ViewModel() {
    private val _homeState = MutableStateFlow(HomeState())
    val homeState: SharedFlow<HomeState> = _homeState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.FetchCategories -> fetchCategories()
            is HomeEvent.FetchCategoryById -> fetchCategoriesById(event.title)
            HomeEvent.ResetErrorMessage -> updateErrorMessage(message = null)
        }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            categoriesUseCase.getCategoriesUseCase().collect() { it ->
                when (it) {
                    is Resource.Error -> updateErrorMessage(message = it.errorMessage)

                    is Resource.Loading -> {
                        _homeState.update { currentState ->
                            currentState.copy(
                                isLoading = it.loading
                            )
                        }
                    }

                    is Resource.Success -> {
                        _homeState.update { currentState ->
                            currentState.copy(
                                categories = it.data.map {
                                    it.toPresenter()
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun fetchCategoriesById(title: String) {
        viewModelScope.launch {
            categoriesUseCase.getCategoriesByIdUseCase(title).collect() { it ->
                when (it) {
                    is Resource.Error -> updateErrorMessage(message = it.errorMessage)

                    is Resource.Loading -> {
                        _homeState.update { currentState ->
                            currentState.copy(
                                isLoading = it.loading
                            )
                        }
                    }

                    is Resource.Success -> {
                        _homeState.update { currentState ->
                            currentState.copy(
                                categories = it.data.map {
                                    it.toPresenter()
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun updateErrorMessage(message: String?) {
        _homeState.update { currentState -> currentState.copy(errorMessage = message) }
    }
}
package com.example.homework26.presentation.screen

import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.homework26.databinding.FragmentHomeBinding
import com.example.homework26.presentation.base.BaseFragment
import com.example.homework26.presentation.event.HomeEvent
import com.example.homework26.presentation.extension.showSnackBar
import com.example.homework26.presentation.state.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeFragmentViewModel by viewModels()
    private lateinit var adapter: HomeFragmentRecyclerViewAdapter

    override fun bind() {
        adapter = HomeFragmentRecyclerViewAdapter()

        binding.apply {
            rvCategoriesRecyclerView.adapter = adapter
        }

        viewModel.onEvent(HomeEvent.FetchCategories)
    }

    override fun bindViewActionListeners() {
        setupSearchListener()
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeState.collect {
                    handleHomeState(it)
                }
            }
        }
    }

    private fun setupSearchListener() {
        var searchJob: Job? = null

        binding.etSearch.doAfterTextChanged { editable ->
            searchJob?.cancel()

            searchJob = viewLifecycleOwner.lifecycleScope.launch {
                val searchQuery = editable.toString().trim()

                if (searchQuery.isNotEmpty()) {
                    viewModel.onEvent(HomeEvent.FetchCategoryById(searchQuery))
                } else {
                    viewModel.onEvent(HomeEvent.FetchCategories)
                }
            }
        }
    }

    private fun handleHomeState(state: HomeState) {
        binding.progress.visibility =
            if (state.isLoading) View.VISIBLE else View.GONE

        state.categories?.let {
            adapter.submitList(it)
        }

        state.errorMessage?.let {
            binding.root.showSnackBar(message = it)
            viewModel.onEvent(HomeEvent.ResetErrorMessage)
        }
    }
}
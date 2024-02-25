package com.example.homework26.presentation.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework26.databinding.ItemLayoutBinding
import com.example.homework26.presentation.model.Categories

class HomeFragmentRecyclerViewAdapter :
    ListAdapter<Categories, HomeFragmentRecyclerViewAdapter.CategoriesViewHolder>(CategoryDiffUtil()) {

    inner class CategoriesViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categories: Categories) = with(binding) {
            tvTitle.text = categories.name
            rvChildrenBalls.adapter = ChildRecyclerViewAdapter(categories.children.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoriesViewHolder(
        ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
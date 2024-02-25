package com.example.homework26.presentation.screen

import androidx.recyclerview.widget.DiffUtil
import com.example.homework26.presentation.model.Categories

class CategoryDiffUtil : DiffUtil.ItemCallback<Categories>() {
    override fun areItemsTheSame(oldItem: Categories, newItem: Categories): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Categories, newItem: Categories): Boolean =
        oldItem == newItem
}
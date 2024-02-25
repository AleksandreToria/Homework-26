package com.example.homework26.presentation.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework26.databinding.BallLayoutBinding

class ChildRecyclerViewAdapter(private val childrenCount: Int) :
    RecyclerView.Adapter<ChildRecyclerViewAdapter.ChildrenViewHolder>() {

    inner class ChildrenViewHolder(binding: BallLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChildrenViewHolder(
        BallLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
        return minOf(childrenCount, 4)
    }

    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) = Unit

}
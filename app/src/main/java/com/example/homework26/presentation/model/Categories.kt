package com.example.homework26.presentation.model

data class Categories(
    val bglNumber: String,
    val bglVariant: String,
    val children: List<Categories>,
    val createdAt: String,
    val id: String,
    val main: String,
    val name: String,
    val nameDe: String,
    val orderId: Int
)
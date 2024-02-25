package com.example.homework26.domain.model

data class GetCategories(
    val bglNumber: String,
    val bglVariant: String,
    val children: List<GetCategories>,
    val createdAt: String,
    val id: String,
    val main: String,
    val name: String,
    val nameDe: String,
    val orderId: Int
)

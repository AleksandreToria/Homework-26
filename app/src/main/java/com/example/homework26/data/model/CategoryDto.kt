package com.example.homework26.data.model

import com.squareup.moshi.Json

data class CategoryDto(
    @Json(name = "bgl_number")
    val bglNumber: String?,
    @Json(name = "bgl_variant")
    val bglVariant: String?,
    val children: List<CategoryDto>,
    val createdAt: String,
    val id: String,
    val main: String?,
    val name: String,
    @Json(name = "name_de")
    val nameDe: String,
    @Json(name = "order_id")
    val orderId: Int?
)
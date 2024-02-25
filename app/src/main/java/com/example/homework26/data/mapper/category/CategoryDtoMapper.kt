package com.example.homework26.data.mapper.category

import com.example.homework26.data.model.CategoryDto
import com.example.homework26.domain.model.GetCategories

fun CategoryDto.toDomain(): GetCategories =
    GetCategories(
        bglNumber = bglNumber ?: "",
        bglVariant = bglVariant ?: "",
        children = children.map { it.toDomain() },
        createdAt = createdAt,
        id = id,
        main = main ?: "",
        name = name,
        nameDe = nameDe,
        orderId = orderId ?: 0
    )

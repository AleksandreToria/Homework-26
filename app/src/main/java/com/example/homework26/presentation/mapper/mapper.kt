package com.example.homework26.presentation.mapper

import com.example.homework26.domain.model.GetCategories
import com.example.homework26.presentation.model.Categories

fun GetCategories.toPresenter(): Categories =
    Categories(
        bglNumber = bglNumber,
        bglVariant = bglVariant,
        children = children.map { it.toPresenter() },
        createdAt = createdAt,
        id = id,
        main = main,
        name = name,
        nameDe = nameDe,
        orderId = orderId
    )

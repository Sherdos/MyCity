package com.example.mycity.models

import androidx.annotation.DrawableRes


data class Place(
    val id: String,
    val categoryId: String,
    val name: String,
    val shortDescription: String,
    val details: String,
    val address: String,
    @DrawableRes val imageRes: Int
)
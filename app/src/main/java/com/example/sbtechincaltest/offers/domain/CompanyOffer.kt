package com.example.sbtechincaltest.offers.domain

data class CompanyOffer(
    val id: Int,
    val description: String,
    val isFavorite: Boolean = false,
    val thumbnailUrl: String,
    val imageUrl: String
)


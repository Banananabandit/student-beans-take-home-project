package com.example.sbtechincaltest

data class OffersScreenState(
    val offers: List<CompanyOffer>,
    val isLoading: Boolean,
    val error: String? = null
)

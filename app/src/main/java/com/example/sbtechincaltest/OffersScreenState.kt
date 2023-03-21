package com.example.sbtechincaltest

import com.example.sbtechincaltest.models.CompanyOffer

data class OffersScreenState(
    val offers: List<CompanyOffer>,
    val isLoading: Boolean,
    val error: String? = null
)
// Just a test bro. Still cant figure out why this wouldnt upload to github yesterday
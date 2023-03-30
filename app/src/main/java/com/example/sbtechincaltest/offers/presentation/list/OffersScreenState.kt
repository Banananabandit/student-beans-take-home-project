package com.example.sbtechincaltest.offers.presentation.list

import androidx.compose.runtime.Stable
import com.example.sbtechincaltest.offers.domain.CompanyOffer
@Stable
data class OffersScreenState(
    val offers: List<CompanyOffer>,
    val isLoading: Boolean,
    val error: String? = null,
)




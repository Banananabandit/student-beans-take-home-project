package com.example.sbtechincaltest

import androidx.compose.runtime.Stable
import androidx.compose.ui.focus.FocusManager
import androidx.navigation.NavHostController
import com.example.sbtechincaltest.models.CompanyOffer
@Stable
data class OffersScreenState(
    val offers: List<CompanyOffer>,
    val isLoading: Boolean,
    val error: String? = null,
)




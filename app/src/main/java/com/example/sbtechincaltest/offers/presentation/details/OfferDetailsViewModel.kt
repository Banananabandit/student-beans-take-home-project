package com.example.sbtechincaltest.offers.presentation.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sbtechincaltest.offers.domain.CompanyOffer
import com.example.sbtechincaltest.offers.data.remote.CompanyOffersApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OfferDetailsViewModel(private val stateHandle: SavedStateHandle): ViewModel() {
    private var restInterface: CompanyOffersApiService
    val state = mutableStateOf<CompanyOffer?>(null)

    init {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        restInterface = retrofit.create(CompanyOffersApiService::class.java)
        val id = stateHandle.get<Int>("offer_id") ?: 0
        viewModelScope.launch {
            val offer = getRemoteOfferDetails(id)
            state.value = offer
        }
    }
    private suspend fun getRemoteOfferDetails(id: Int): CompanyOffer {
        return withContext(Dispatchers.IO) {
            restInterface.getOffer(id).first().let {
                CompanyOffer(
                    id = it.id,
                    description = it.description,
                    imageUrl = it.imageUrl,
                    thumbnailUrl = it.thumbnailUrl
                )
            }
        }
    }
}
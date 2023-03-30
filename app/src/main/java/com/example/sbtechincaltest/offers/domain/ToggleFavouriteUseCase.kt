package com.example.sbtechincaltest.offers.domain

import com.example.sbtechincaltest.offers.data.OffersRepository

class ToggleFavouriteUseCase {
    private val repository: OffersRepository = OffersRepository()
    private val getSortedOffersUseCase = GetSortedOffersUseCase()
    suspend operator fun invoke(id: Int, oldValue: Boolean): List<CompanyOffer> {
        val newFavourite = oldValue.not()
        repository.toggleFavouriteOffer(id, newFavourite)
        return getSortedOffersUseCase()
    }
}
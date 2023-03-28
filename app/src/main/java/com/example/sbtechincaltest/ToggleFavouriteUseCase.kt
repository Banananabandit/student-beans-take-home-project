package com.example.sbtechincaltest

import com.example.sbtechincaltest.models.CompanyOffer

class ToggleFavouriteUseCase {
    private val repository: OffersRepository = OffersRepository()
    private val getSortedOffersUseCase = GetSortedOffersUseCase()
    suspend operator fun invoke(id: Int, oldValue: Boolean): List<CompanyOffer> {
        val newFavourite = oldValue.not()
        repository.toggleFavouriteOffer(id, newFavourite)
        return getSortedOffersUseCase()
    }
}
package com.example.sbtechincaltest.offers.domain

import com.example.sbtechincaltest.offers.data.OffersRepository

class GetSortedOffersUseCase {
    private val repository: OffersRepository = OffersRepository()
    suspend operator fun invoke(): List<CompanyOffer> {
        return repository.getOffers()
            .sortedBy { it.description }
    }
}
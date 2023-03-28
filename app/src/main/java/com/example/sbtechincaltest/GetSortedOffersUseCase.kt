package com.example.sbtechincaltest

import com.example.sbtechincaltest.models.CompanyOffer

class GetSortedOffersUseCase {
    private val repository: OffersRepository = OffersRepository()
    suspend operator fun invoke(): List<CompanyOffer> {
        return repository.getOffers()
            .sortedBy { it.description }
    }
}
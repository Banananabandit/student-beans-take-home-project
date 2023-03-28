package com.example.sbtechincaltest

import com.example.sbtechincaltest.models.CompanyOffer


class GetInitialOffersUseCase {
    // We called it as invoke and operator (one cant live without the other) so that we can call the class without the method name
    // So now we can simply do val useCase = GetOffersUseCase(). This is also achievable because
    // this class has only one method
    private val repository: OffersRepository = OffersRepository()
    private val getSortedOffersUseCase = GetSortedOffersUseCase()
    suspend operator fun invoke() : List<CompanyOffer> {
        repository.loadOffers()
        return getSortedOffersUseCase()
    }
}
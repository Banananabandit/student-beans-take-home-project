package com.example.sbtechincaltest

import com.example.sbtechincaltest.models.CompanyOffer
import com.example.sbtechincaltest.models.PartialOffer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.UnknownHostException

class OffersRepository {
    private var restInterface: CompanyOffersApiService =
     Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .build()
        .create(CompanyOffersApiService::class.java)
    private var offersDao = OffersDb.getDaoInstance(OffersApplication.getAppContext())

    suspend fun toggleFavouriteOffer(id: Int, value: Boolean) =
        withContext(Dispatchers.IO) {
            offersDao.update(PartialOffer(id = id, isFavourite = value))
        }
    /*
* Whenever we call this fun, the dispatcher is going to get switched to IO. This way we dont have
* to worry about which dispatchers our caller functions are using. So in a way it acts as an intermediary
* between callers and the emitter.
* */
    suspend fun loadOffers() {
        return withContext(Dispatchers.IO) {
            try {
                refreshCache()
            } catch (e: Exception) {
                when (e) {
                    is UnknownHostException,
                    is ConnectException,
                    is HttpException -> {
                        if (offersDao.getAll().isEmpty())
                            throw Exception("Please connect to internet.")
                    }
                    else -> throw e
                }
            }
        }
    }

    // This method will only return offers from the cache
    suspend fun getOffers() : List<CompanyOffer> {
        return withContext(Dispatchers.IO) {
            return@withContext offersDao.getAll()
        }
    }

    private suspend fun refreshCache() {
        val remoteOffers = restInterface.getOffers()
        val favouriteOffers = offersDao.getAllFavourited()
        offersDao.addAll(remoteOffers)
        offersDao.updateAll(
            favouriteOffers.map {
                PartialOffer(it.id, true)
            }
        )
    }

}
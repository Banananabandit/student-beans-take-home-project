package com.example.sbtechincaltest

import androidx.room.*
import com.example.sbtechincaltest.models.CompanyOffer
import com.example.sbtechincaltest.models.LocalPartialOffer

@Dao
interface OffersDao {
    @Query("SELECT * FROM offers")
    suspend fun getAll(): List<LocalOffers>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(offers: List<LocalOffers>)

    @Update(entity = LocalOffers::class)
    suspend fun update(localPartialOffer: LocalPartialOffer)

    @Update(entity = LocalOffers::class)
    suspend fun updateAll(localPartialOffers: List<LocalPartialOffer>)

    //TODO: Use this for the bottom nav bar "favourited" tab
    @Query("SELECT * FROM offers WHERE is_favourite = 1")
    suspend fun getAllFavourited(): List<LocalOffers>
}
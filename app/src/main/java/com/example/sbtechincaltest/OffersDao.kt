package com.example.sbtechincaltest

import androidx.room.*

@Dao
interface OffersDao {
    @Query("SELECT * FROM offers")
    suspend fun getAll(): List<CompanyOffer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(offers: List<CompanyOffer>)

    @Update(entity = CompanyOffer::class)
    suspend fun update(partialOffer: PartialOffer)

    @Update(entity = CompanyOffer::class)
    suspend fun updateAll(partialOffers: List<PartialOffer>)

    // This guy can be used for the bottom nav just to display the favourites
    @Query("SELECT * FROM offers WHERE is_favourite = 1")
    suspend fun getAllFavourited(): List<CompanyOffer>
}
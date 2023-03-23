package com.example.sbtechincaltest

import androidx.room.*
import com.example.sbtechincaltest.models.CompanyOffer
import com.example.sbtechincaltest.models.PartialOffer

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

    //TODO: Use this for the bottom nav bar "favourited" tab
    @Query("SELECT * FROM offers WHERE is_favourite = 1")
    suspend fun getAllFavourited(): List<CompanyOffer>
}
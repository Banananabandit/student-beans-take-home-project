package com.example.sbtechincaltest

import com.example.sbtechincaltest.models.CompanyOffer
import retrofit2.http.GET
import retrofit2.http.Query

/* https://jsonplaceholder.typicode.com/photos
 show the image from `thumbnailUrl` and the `title`
 Add hierarchy- display albums first or implement bottom nav with the tab for categories
 To get a specific item  pass ?id=
 To get a specific album pass ?albumId=
 */
interface CompanyOffersApiService {
    @GET("photos")
    suspend fun getOffers(): List<CompanyOffer>

    @GET("photos")
    suspend fun getOffer(@Query("id") id: Int): Array<CompanyOffer>
}
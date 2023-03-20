package com.example.sbtechincaltest

import retrofit2.http.GET
import retrofit2.http.Query

/* https://jsonplaceholder.typicode.com/photos
 show the image from `thumbnailUrl` and the `title`
 Add hierarchy- display albums first or implement bottom nav with the tab for categories
 To get a specific item  pass ?id=
 To get a specific album pass ?albumId=
 */
interface CompanyOffersApiService {
    @GET("photos") // This will be appended after the base URL
    suspend fun getOffers(): List<CompanyOffer>

    // Since we need to query a specific Id this function has take in an input
    @GET("photos")
    suspend fun getOffer(@Query("id") id: Int): Array<CompanyOffer>
}
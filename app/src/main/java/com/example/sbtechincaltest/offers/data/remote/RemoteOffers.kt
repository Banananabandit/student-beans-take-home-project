package com.example.sbtechincaltest.offers.data.remote

import com.google.gson.annotations.SerializedName

data class RemoteOffers(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val description: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,

    @SerializedName("url")
    val imageUrl: String
)
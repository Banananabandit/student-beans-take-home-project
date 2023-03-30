package com.example.sbtechincaltest.offers.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class LocalPartialOffer(
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "is_favourite")
    val isFavourite: Boolean
)
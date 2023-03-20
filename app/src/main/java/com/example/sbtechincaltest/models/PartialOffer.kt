package com.example.sbtechincaltest.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class PartialOffer(
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "is_favourite")
    val isFavourite: Boolean
)
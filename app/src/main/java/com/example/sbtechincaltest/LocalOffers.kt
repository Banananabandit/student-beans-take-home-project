package com.example.sbtechincaltest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offers")
data class LocalOffers(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val description: String,

    @ColumnInfo(name = "is_favourite")
    val isFavorite: Boolean = false,

    @ColumnInfo(name = "thumbnailUrl")
    val thumbnailUrl: String = "",

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String = ""
)

package com.example.sbtechincaltest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "offers")
data class CompanyOffer(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val description: String,

    @ColumnInfo(name = "is_favourite")
    val isFavorite: Boolean = false
)


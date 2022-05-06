package com.example.countrytwo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Country(
    @ColumnInfo(name = "name")
    @SerializedName("countryname")
    val countryname: String?,
    @ColumnInfo(name = "caital")
    @SerializedName("capital")
    val capital:String?,
    @ColumnInfo(name = "region")
    @SerializedName("region")
    val countryRegion:String?,
    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    val currency:String?,
    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val imageurl:String?,
    @ColumnInfo(name = "language")
    @SerializedName("language")
    val language:String?
)
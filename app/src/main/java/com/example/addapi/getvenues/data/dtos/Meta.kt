package com.example.addapi.getvenues.data.dtos


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Meta(
    @SerializedName("geolocation")
    val geolocation: Geolocation?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("took")
    val took: Int?,
    @SerializedName("total")
    val total: Int?
) : Parcelable
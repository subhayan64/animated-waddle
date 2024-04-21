package com.example.addapi.getvenues.data.dtos


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Geolocation(
    @SerializedName("city")
    val city: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("display_name")
    val displayName: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("metro_code")
    val metroCode: String?,
    @SerializedName("postal_code")
    val postalCode: String?,
    @SerializedName("range")
    val range: String?,
    @SerializedName("state")
    val state: String?
) : Parcelable
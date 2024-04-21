package com.example.addapi.getvenues.data.dtos


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class VenuesDto(
    @SerializedName("meta")
    val meta: Meta?,
    @SerializedName("venues")
    val venues: List<Venue?>?
) : Parcelable
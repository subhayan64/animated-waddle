package com.example.addapi.getvenues.data.dtos


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Stats(
    @SerializedName("event_count")
    val eventCount: Int?
) : Parcelable
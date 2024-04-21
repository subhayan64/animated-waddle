package com.example.addapi.getvenues.data.dtos


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Venue(
    @SerializedName("access_method")
    val accessMethod: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("capacity")
    val capacity: Int?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("display_location")
    val displayLocation: String?,
    @SerializedName("extended_address")
    val extendedAddress: String?,
    @SerializedName("has_upcoming_events")
    val hasUpcomingEvents: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("links")
    val links: List<String?>?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("metro_code")
    val metroCode: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("name_v2")
    val nameV2: String?,
    @SerializedName("num_upcoming_events")
    val numUpcomingEvents: Int?,
    @SerializedName("popularity")
    val popularity: Int?,
    @SerializedName("postal_code")
    val postalCode: String?,
    @SerializedName("score")
    val score: Int?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("stats")
    val stats: Stats?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("url")
    val url: String?
) : Parcelable
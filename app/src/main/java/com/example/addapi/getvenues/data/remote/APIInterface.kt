package com.example.addapi.getvenues.data.remote

import com.example.addapi.getvenues.data.dtos.VenuesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {


    @GET("/2/venues/")
    suspend fun getVenues(
        @Query("per_page") perPage: String,
        @Query("page") page: String,
        @Query("client_id") client_id: String,
        @Query("lon") lon: String,
        @Query("lat") lat: String,
        @Query("range") range: String,

    ): Response<VenuesDto>
}
package com.example.addapi.getvenues.data.remote

import com.example.addapi.getvenues.data.dtos.VenuesDto
import retrofit2.Response

interface APIHelper {

    suspend fun getVenues() : Response<VenuesDto>
}
package com.example.addapi.getvenues.data.repository

import com.example.addapi.getvenues.data.dtos.VenuesDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface VenuesRepository {

    suspend fun getVenues() : Flow<Response<VenuesDto>>
}
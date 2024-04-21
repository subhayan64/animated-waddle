package com.example.addapi.getvenues.data.repository

import com.example.addapi.getvenues.data.dtos.VenuesDto
import com.example.addapi.getvenues.data.remote.APIHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class VenuesRepositoriesImpl @Inject constructor(private val apiHelper: APIHelper) : VenuesRepository {

    override suspend fun getVenues(): Flow<Response<VenuesDto>> {
        return flow {
            emit(
                apiHelper.getVenues()
            )
        }
    }
}
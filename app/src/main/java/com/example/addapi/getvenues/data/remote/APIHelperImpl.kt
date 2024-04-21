package com.example.addapi.getvenues.data.remote

import android.os.Build
import androidx.core.os.BuildCompat
import com.example.addapi.BuildConfig
import com.example.addapi.R
import com.example.addapi.getvenues.data.dtos.VenuesDto
import retrofit2.Response
import javax.inject.Inject

class APIHelperImpl @Inject constructor(private val apiInterface: APIInterface) : APIHelper {

    override suspend fun getVenues(): Response<VenuesDto> {

        return apiInterface.getVenues(
            perPage = "10",
            page = "1",
            client_id = BuildConfig.CLIENT_ID,
            lon = "77.594566",
            lat = "12.971599",
            range = "12mi"
        )
    }
}
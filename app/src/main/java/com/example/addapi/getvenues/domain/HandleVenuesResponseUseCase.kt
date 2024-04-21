package com.example.addapi.getvenues.domain

import com.example.addapi.getvenues.data.dtos.VenuesDto
import com.example.addapi.getvenues.ui.dataobject.VenuesStates
import retrofit2.Response

class HandleVenuesResponseUseCase {

    operator fun invoke(data: Response<VenuesDto>): VenuesStates {

        var state: VenuesStates = VenuesStates.Loading
        state = when {
            data.isSuccessful -> {
                if (data.body() != null) {
                    VenuesStates.Success(venuesDto = data.body()!!)
                } else{
                    VenuesStates.Error(error = "Something went wrong!")
                }
            }

            else -> {
                VenuesStates.Error(error = data.errorBody().toString())
            }
        }

        return state
    }
}
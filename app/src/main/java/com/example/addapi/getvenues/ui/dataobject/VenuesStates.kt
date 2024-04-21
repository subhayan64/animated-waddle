package com.example.addapi.getvenues.ui.dataobject

import com.example.addapi.getvenues.data.dtos.VenuesDto

sealed class VenuesStates {

    data object Loading : VenuesStates()

    data class Success(val venuesDto: VenuesDto) : VenuesStates()

    data class Error(val error: String) : VenuesStates()
}
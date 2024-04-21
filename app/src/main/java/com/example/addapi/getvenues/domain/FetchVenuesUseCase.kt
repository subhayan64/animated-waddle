package com.example.addapi.getvenues.domain

import com.example.addapi.getvenues.data.repository.VenuesRepository
import com.example.addapi.getvenues.ui.dataobject.VenuesStates
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchVenuesUseCase @Inject constructor(
    private val coroutineContextProvider: CoroutineDispatcher, private val mRepository: VenuesRepository
) {

    suspend operator fun invoke(): VenuesStates {
        var state: VenuesStates = VenuesStates.Loading

        mRepository.getVenues().flowOn(coroutineContextProvider).catch {
            state = VenuesStates.Error(error = it.message.toString())
        }.collect {

            state = HandleVenuesResponseUseCase().invoke(it)
        }

        return state
    }
}
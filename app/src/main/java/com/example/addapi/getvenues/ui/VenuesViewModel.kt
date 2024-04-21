package com.example.addapi.getvenues.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.addapi.getvenues.domain.FetchVenuesUseCase
import com.example.addapi.getvenues.ui.dataobject.VenuesStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VenuesViewModel @Inject constructor(
    private val fetchVenues: FetchVenuesUseCase,
) : ViewModel() {

    private val _venues = MutableStateFlow<VenuesStates>(VenuesStates.Loading)

    val venues = _venues as StateFlow<VenuesStates>

    fun fetchVenuesData() {
        viewModelScope.launch {
            _venues.value = fetchVenues.invoke()
        }
    }
}
package com.example.addapi.getvenues.ui

import android.os.Bundle
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.addapi.getvenues.ui.dataobject.VenuesStates
import com.example.addapi.getvenues.ui.dataobject.VenuesStates.Error
import com.example.addapi.getvenues.ui.dataobject.VenuesStates.Loading
import com.example.addapi.getvenues.ui.dataobject.VenuesStates.Success
import com.example.addapi.getvenues.ui.theme.AddApiTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mViewModel by viewModels<VenuesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DisplayVenues("Android", mViewModel)
                }
            }
        }

        mViewModel.fetchVenuesData()
    }
}

@Composable
fun DisplayVenues(name: String, viewModel: VenuesViewModel) {

    val venueState by viewModel.venues.collectAsState()



    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Text(text = "Venue Info:")
        when (val state: VenuesStates = venueState) {
            is Error -> Text(text = "Error: ${state.error}")
            Loading -> CircularProgressIndicator()
            is Success -> {

                if (state.venuesDto.venues != null && !state.venuesDto.venues.isEmpty()) {
                    val venueList = state.venuesDto.venues
                    LazyColumn {
                        items(venueList) {
                            VenueCard(
                                name = it?.name ?: "", address = it?.address ?: "", city = it?.city ?: ""
                            )

                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun VenueCard(name: String = "asd", address: String = "12", city: String = "sadf") {

    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = address)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = city)
        }
    }
}


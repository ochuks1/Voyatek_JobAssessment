package com.example.voyatekjobassessment.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.voyatekjobassessment.viewmodel.TripViewModel

@Composable
fun TripListScreen(
    viewModel: TripViewModel,
    onCreateTrip: () -> Unit,
    onViewTrip: (Int) -> Unit
) {
    // Load once
    LaunchedEffect(Unit) { viewModel.loadTrips() }

    val tripsState = viewModel.trips.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Plan a Trip", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(4.dp))
        Text(
            "Your trip itineraries and planned trips are placed here",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.height(16.dp))

        // CTA area similar to “Plan Your Dream Trip in Minutes”
        Text(
            "Plan Your Dream Trip in Minutes",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            "Build, personalize, and optimize your itineraries with our trip planner. " +
                    "Perfect for getaways, remote workcations, and any spontaneous escapade.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = onCreateTrip) { Text("Create a Trip") }

        Spacer(Modifier.height(24.dp))
        Text("Planned Trips", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(8.dp))

        tripsState.value.forEach { trip ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onViewTrip(trip.id ?: 0) }
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(trip.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    Text("${trip.startDate}  •  ${trip.endDate}")
                    Spacer(Modifier.height(4.dp))
                    Text("${trip.destination}")
                }
            }
        }
    }
}
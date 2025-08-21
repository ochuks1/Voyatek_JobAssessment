package com.example.voyatekjobassessment.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.voyatekjobassessment.R
import com.example.voyatekjobassessment.data.model.Trip

@Composable
fun TripDetailsScreen(trip: Trip?) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        if (trip == null) {
            Text("No trip found", style = MaterialTheme.typography.bodyLarge)
            return@Column
        }

        Text("${trip.startDate}  ${trip.endDate}", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(6.dp))
        Text(trip.title, style = MaterialTheme.typography.titleLarge)
        Text("${trip.destination}  |  ${trip.type}", style = MaterialTheme.typography.bodyMedium)

        Spacer(Modifier.height(12.dp))
        // Optional image placeholder
        Image(
            painter = painterResource(id = R.drawable.ic_palm_tree),
            contentDescription = "Trip Image",
            modifier = Modifier.fillMaxWidth().height(160.dp)
        )

        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { /* TODO: Collaboration */ }) { Text("Trip Collaboration") }
            OutlinedButton(onClick = { /* TODO: Share */ }) { Text("Share Trip") }
        }

        Spacer(Modifier.height(24.dp))
        Text("Trip itineraries", style = MaterialTheme.typography.titleMedium)
        Text("Your trip itineraries are placed here", style = MaterialTheme.typography.bodyMedium)

        Spacer(Modifier.height(16.dp))
        TripSectionCard(title = "Activities", emptyText = "No request yet", action = "Add Activities")
        Spacer(Modifier.height(12.dp))
        TripSectionCard(title = "Hotels", emptyText = "No request yet", action = "Add Hotels")
        Spacer(Modifier.height(12.dp))
        TripSectionCard(title = "Flights", emptyText = "No request yet", action = "Add Flights")
    }
}

@Composable
private fun TripSectionCard(title: String, emptyText: String, action: String) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(6.dp))
            Text(emptyText, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = { /* TODO */ }) { Text(action) }
        }
    }
}
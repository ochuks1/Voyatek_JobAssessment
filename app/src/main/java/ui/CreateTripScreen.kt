package com.example.voyatekjobassessment.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateTripScreen(onSaveTrip: (String, String, String, String) -> Unit) {
    var tripTitle by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var dateRange by remember { mutableStateOf("") }
    var tripType by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create a Trip",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Trip Title
        OutlinedTextField(
            value = tripTitle,
            onValueChange = { tripTitle = it },
            label = { Text("Trip Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Trip Destination
        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Destination") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Range for dates
        OutlinedTextField(
            value = dateRange,
            onValueChange = { dateRange = it },
            label = { Text("Date Range (e.g. 21 Mar - 21 Apr)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Type of trip
        OutlinedTextField(
            value = tripType,
            onValueChange = { tripType = it },
            label = { Text("Trip Type (e.g. Family, Solo)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Save Button
        Button(
            onClick = {
                onSaveTrip(tripTitle, destination, dateRange, tripType)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Trip")
        }
    }
}
package com.example.voyatekjobassessment.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FlightSummaryScreen(onConfirm: () -> Unit = {}) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Flight Summary", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        Text("New York → LAX")
        Text("Date: 21 March 2024")
        Text("Airline: Example Air")
        Text("Price: $350")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onConfirm) { Text("Confirm Booking") }
    }
}
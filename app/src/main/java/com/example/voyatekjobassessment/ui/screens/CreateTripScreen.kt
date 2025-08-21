package com.example.voyatekjobassessment.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.voyatekjobassessment.data.model.Trip
import com.example.voyatekjobassessment.viewmodel.TripViewModel

@Composable
fun CreateTripScreen(viewModel: TripViewModel, onTripCreated: () -> Unit) {
    var title by remember { mutableStateOf("") }            // The trip name for customers
    var type by remember { mutableStateOf("") }             // Travel style for customers
    var description by remember { mutableStateOf("") }      // Trip description for customers
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }

    // I used style chips as given on Figma (Solo, Couple, Family, Group)
    val styles = listOf("Solo", "Couple", "Family", "Group")

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Plan a Trip", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(4.dp))
        Text("Let's Go! Build Your Next Adventure", style = MaterialTheme.typography.bodyMedium)

        Spacer(Modifier.height(16.dp))
        Text("Trip Name", style = MaterialTheme.typography.titleSmall)
        OutlinedTextField(
            value = title, onValueChange = { title = it },
            placeholder = { Text("Enter the trip name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))
        Text("Travel Style", style = MaterialTheme.typography.titleSmall)
        FlowRowMain {
            styles.forEach { s ->
                FilterChip(
                    selected = (type == s),
                    onClick = { type = s },
                    label = { Text(s) }
                )
            }
        }

        Spacer(Modifier.height(12.dp))
        Text("Trip Description", style = MaterialTheme.typography.titleSmall)
        OutlinedTextField(
            value = description, onValueChange = { description = it },
            placeholder = { Text("Tell us more about the trip") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))
        Text("Where to ?", style = MaterialTheme.typography.titleSmall)
        OutlinedTextField(
            value = destination, onValueChange = { destination = it },
            placeholder = { Text("Select City") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                Text("Start Date", style = MaterialTheme.typography.titleSmall)
                OutlinedTextField(
                    value = startDate, onValueChange = { startDate = it },
                    placeholder = { Text("Enter Date") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text("End Date", style = MaterialTheme.typography.titleSmall)
                OutlinedTextField(
                    value = endDate, onValueChange = { endDate = it },
                    placeholder = { Text("Enter Date") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            val trip = Trip(
                title = title,
                destination = if (description.isBlank()) destination else destination,
                startDate = startDate,
                endDate = endDate,
                type = type
            )
            viewModel.createTrip(trip) { created ->
                if (created != null) onTripCreated()
            }
        }) {
            Text("Create a Trip")
        }
    }
}

@Composable
private fun FlowRowMain(content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = content
    )
}


@Composable
private fun FilterChip(selected: Boolean, onClick: () -> Unit, label: @Composable () -> Unit) {
    AssistChip(
        onClick = onClick,
        label = label,
        leadingIcon = if (selected) {
            { Icon(Icons.Filled.Check, contentDescription = null) }
        } else null
    )
}
package com.example.voyatekjobassessment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voyatekjobassessment.data.api.ApiClient
import com.example.voyatekjobassessment.data.model.Trip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TripViewModel : ViewModel() {

    private val _trips = MutableStateFlow<List<Trip>>(emptyList())
    val trips: StateFlow<List<Trip>> = _trips.asStateFlow()

    fun loadTrips() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getTrips()
                _trips.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun createTrip(trip: Trip, onComplete: ((Trip?) -> Unit)? = null) {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.createTrip(trip)
                _trips.value = _trips.value + response
                onComplete?.invoke(response)
            } catch (e: Exception) {
                e.printStackTrace()
                onComplete?.invoke(null)
            }
        }
    }

    fun getTripById(id: Int?): Trip? = _trips.value.firstOrNull { it.id == id }
}
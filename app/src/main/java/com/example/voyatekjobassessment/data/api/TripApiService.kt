package com.example.voyatekjobassessment.data.api

import com.example.voyatekjobassessment.data.model.Trip
import retrofit2.http.*

interface TripApiService {

    @GET("/trips")
    suspend fun getTrips(): List<Trip>

    @POST("/trips")
    suspend fun createTrip(@Body trip: Trip): Trip
}
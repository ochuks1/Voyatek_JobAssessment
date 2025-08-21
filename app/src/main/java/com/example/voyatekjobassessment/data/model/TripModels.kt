package com.example.voyatekjobassessment.data.model

data class Trip(
    val id: Int? = null,
    val title: String,
    val destination: String,
    val startDate: String,
    val endDate: String,
    val type: String
)
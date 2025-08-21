package com.example.voyatekjobassessment.data.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    private const val BASE_URL = "https://ca16796f6987c5af88a7.free.beeceptor.com/"

    val apiService: TripApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(TripApiService::class.java)
    }
}
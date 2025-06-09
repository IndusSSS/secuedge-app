package com.secuedge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Builds Retrofit client for cloud API.
 */
object ApiClient {
    private const val BASE_URL = "https://cloud.smartsecurity.solutions"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

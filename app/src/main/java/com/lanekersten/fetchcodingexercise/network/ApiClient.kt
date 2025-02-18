package com.lanekersten.fetchcodingexercise.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val retrofit: Retrofit by lazy {
         Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val fetchService: FetchService by lazy {
        retrofit.create(FetchService::class.java)
    }

}
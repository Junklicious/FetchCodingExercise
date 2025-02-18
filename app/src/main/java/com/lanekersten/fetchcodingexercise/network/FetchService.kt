package com.lanekersten.fetchcodingexercise.network

import com.lanekersten.fetchcodingexercise.model.ListItem
import retrofit2.Response
import retrofit2.http.GET

interface FetchService {

    @GET("/hiring.json")
    suspend fun getListItems() : Response<List<ListItem>>

}
package com.robertoazeredo.nytimes.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("all/all.json")
    fun getNews(
        @Query("api-key") apiKey: String = "HAvkXB7TKnNJNoOw3ZDzADMfT2pmJal8"
    ): Call<String>
}
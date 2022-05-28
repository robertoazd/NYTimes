package com.robertoazeredo.nytimes.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    @GET("all/{section}.json")
    fun getNews(
        @Path("section") section: String,
        @Query("api-key") apiKey: String = "HAvkXB7TKnNJNoOw3ZDzADMfT2pmJal8"
    ): Call<String>
}
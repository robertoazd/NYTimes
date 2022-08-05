package com.robertoazeredo.nytimes.data.api

import com.robertoazeredo.nytimes.BuildConfig
import com.robertoazeredo.nytimes.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    @GET("all/{section}.json")
    suspend fun getNews(
        @Path("section") section: String,
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): Response<NewsResponse>
}
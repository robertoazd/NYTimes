package com.robertoazeredo.nytimes.data.repository

import com.robertoazeredo.nytimes.data.api.ApiService
import retrofit2.Call

class NewsRepository {

    fun getNews(section: String): Call<String> = ApiService.newsApi.getNews(section = section)
}
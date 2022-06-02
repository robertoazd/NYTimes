package com.robertoazeredo.nytimes.data.repository

import com.robertoazeredo.nytimes.data.api.ApiService
import com.robertoazeredo.nytimes.data.model.NewsResponse
import retrofit2.Call

class NewsRepository {

    fun getNews(section: String): Call<NewsResponse> = ApiService.newsApi.getNews(section = section)
}
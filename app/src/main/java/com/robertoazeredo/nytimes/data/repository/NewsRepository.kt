package com.robertoazeredo.nytimes.data.repository

import com.robertoazeredo.nytimes.data.api.Result
import com.robertoazeredo.nytimes.data.model.NewsResponse

interface NewsRepository {
    suspend fun getNews(section: String): Result<NewsResponse>
}
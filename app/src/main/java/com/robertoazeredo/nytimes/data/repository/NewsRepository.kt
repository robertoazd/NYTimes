package com.robertoazeredo.nytimes.data.repository

import com.robertoazeredo.nytimes.data.api.ApiService
import com.robertoazeredo.nytimes.data.api.Result
import com.robertoazeredo.nytimes.data.model.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository {

    suspend fun getNews(section: String): Result<NewsResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = ApiService.newsApi.getNews(section = section)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    Result.Success(body)
                } else {
                    Result.Error("Error ${response.message()}")
                }
            } catch (throwable: Throwable) {
                Result.Error("Error ${throwable.message}")
            }
        }
    }
}
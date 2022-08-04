package com.robertoazeredo.nytimes.data.repository

import com.robertoazeredo.nytimes.R
import com.robertoazeredo.nytimes.data.api.NewsApi
import com.robertoazeredo.nytimes.data.api.Result
import com.robertoazeredo.nytimes.data.model.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun getNews(section: String): Result<NewsResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = newsApi.getNews(section = section)
                val body = response.body()
                if (response.isSuccessful) {
                    if (body != null) {
                        Result.Success(body)
                    } else {
                        Result.Error(R.string.error_no_data)
                    }
                } else {
                    val errorMessage = when (response.code()) {
                        400 -> R.string.error_400
                        401 -> R.string.error_401
                        403 -> R.string.error_403
                        404 -> R.string.error_404
                        500 -> R.string.error_500
                        503 -> R.string.error_503
                        else -> R.string.error_unknown
                    }
                    Result.Error(errorMessage)
                }
            } catch (throwable: Throwable) {
                Result.Error(R.string.error_unknown)
            }
        }
    }
}
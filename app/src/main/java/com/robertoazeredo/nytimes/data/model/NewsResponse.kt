package com.robertoazeredo.nytimes.data.model

import com.squareup.moshi.Json

data class NewsResponse(
    @Json(name = "status")
    val status: String?,
    @Json(name = "num_results")
    val numResults: String?,
    @Json(name = "results")
    val results: List<Article>?
)

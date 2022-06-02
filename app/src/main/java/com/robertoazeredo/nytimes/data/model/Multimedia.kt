package com.robertoazeredo.nytimes.data.model

import com.squareup.moshi.Json

data class Multimedia(
    @Json(name = "url")
    val url: String?,
    @Json(name = "format")
    val format: String?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "width")
    val width: Int?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "subtype")
    val subtype: String?,
    @Json(name = "caption")
    val caption: String?,
    @Json(name = "copyright")
    val copyright: String?
)

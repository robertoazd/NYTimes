package com.robertoazeredo.nytimes.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    @Json(name = "slug_name")
    val slugName: String?,
    @Json(name = "section")
    val section: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "abstract")
    val abstract: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "byline")
    val byline: String?,
    @Json(name = "thumbnail_standard")
    val thumbnailStandard: String?,
    @Json(name = "source")
    val source: String?,
    @Json(name = "updated_date")
    val updateDate: String?,
    @Json(name = "published_date")
    val publishedDate: String?,
    @Json(name = "material_type_facet")
    val materialTypeFacet: String?,
    @Json(name = "multimedia")
    val multimedia: List<Multimedia>?
): Parcelable

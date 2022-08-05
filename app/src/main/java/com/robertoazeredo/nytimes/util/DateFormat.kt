package com.robertoazeredo.nytimes.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {

    fun getDate(inputDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
        val outputFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH)
        val date = inputFormat.parse(inputDate)
        val formattedDate = if (date != null) {
            outputFormat.format(date)
        } else {
            ""
        }
        return formattedDate
    }
}
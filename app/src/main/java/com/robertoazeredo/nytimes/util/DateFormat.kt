package com.robertoazeredo.nytimes.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {

    fun getDate(inputDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("MM-dd-yyyy", Locale.getDefault())
        val date = inputFormat.parse(inputDate)
        val formattedDate = if (date != null) {
            outputFormat.format(date)
        } else {
            ""
        }
        return formattedDate
    }

//    fun getDate2(inputDate: String): String {
//        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
//        val date = inputFormat.parse(inputDate)
//        val formattedDate = if (date != null) {
//            date.day
//            date.month
//            date.year
//            "May 4, 2022"
//        } else {
//            ""
//        }
//        return formattedDate
//    }
}
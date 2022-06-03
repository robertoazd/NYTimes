package com.robertoazeredo.nytimes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertoazeredo.nytimes.data.api.Result
import com.robertoazeredo.nytimes.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val newsRepository = NewsRepository()

    fun getNews(section: String) {
        viewModelScope.launch {
           when(val result = newsRepository.getNews(section)) {
               is Result.Success -> {
                   println(result.value)
               }
               is Result.Error -> {
                   println(result.message)
               }
           }
        }
    }
}
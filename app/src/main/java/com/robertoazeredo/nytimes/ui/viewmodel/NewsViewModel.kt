package com.robertoazeredo.nytimes.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertoazeredo.nytimes.data.api.Result
import com.robertoazeredo.nytimes.data.model.Article
import com.robertoazeredo.nytimes.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val newsRepository = NewsRepository()

    private val _articles = MutableLiveData<List<Article>?>()
    val articles: LiveData<List<Article>?> get() = _articles

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getNews(section: String) {
        viewModelScope.launch {
           when(val result = newsRepository.getNews(section)) {
               is Result.Success -> {
                   _articles.postValue(result.value.results)
               }
               is Result.Error -> {
                   _errorMessage.postValue(result.message)
               }
           }
        }
    }
}
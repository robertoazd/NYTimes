package com.robertoazeredo.nytimes.di

import com.robertoazeredo.nytimes.data.repository.NewsRepository
import com.robertoazeredo.nytimes.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindNewsRepository(newsRepository: NewsRepositoryImpl): NewsRepository
}
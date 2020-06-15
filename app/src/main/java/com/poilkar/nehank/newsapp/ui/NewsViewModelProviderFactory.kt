package com.poilkar.nehank.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poilkar.nehank.newsapp.repo.NewsRepository
import com.poilkar.nehank.newsapp.util.NewsViewModel

class NewsViewModelProviderFactory(val newsRepository: NewsRepository) : ViewModelProvider.Factory {



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }


}
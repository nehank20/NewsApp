package com.poilkar.nehank.newsapp.util

import androidx.lifecycle.ViewModel
import com.poilkar.nehank.newsapp.repo.NewsRepository

class NewsViewModel(val newsRepository: NewsRepository)  : ViewModel() {
}
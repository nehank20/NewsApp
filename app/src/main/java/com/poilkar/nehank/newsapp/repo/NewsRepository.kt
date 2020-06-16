package com.poilkar.nehank.newsapp.repo

import com.poilkar.nehank.newsapp.api.RetrofitInstance
import com.poilkar.nehank.newsapp.db.ArticleDatabase

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchBreakingNews(searchQuery, pageNumber)

}
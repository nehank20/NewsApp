package com.poilkar.nehank.newsapp.repo

import com.poilkar.nehank.newsapp.api.RetrofitInstance
import com.poilkar.nehank.newsapp.db.ArticleDatabase
import com.poilkar.nehank.newsapp.model.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchBreakingNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedArticles() = db.getArticleDao().getSavedArticles()

    suspend fun delete(article: Article) = db.getArticleDao().deleteArticle(article)

}
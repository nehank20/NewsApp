package com.poilkar.nehank.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.poilkar.nehank.newsapp.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getSavedArticles() : LiveData<List<Article>>

    @Delete()
    suspend fun deleteArticle(article: Article)


}
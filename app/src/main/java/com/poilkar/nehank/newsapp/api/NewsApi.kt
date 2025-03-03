package com.poilkar.nehank.newsapp.api

import com.poilkar.nehank.newsapp.model.NewsResponse
import com.poilkar.nehank.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        country : String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey : String = API_KEY

    ) : Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun searchBreakingNews(
        @Query("q")
        search : String ,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey : String = API_KEY

    ) : Response<NewsResponse>
}
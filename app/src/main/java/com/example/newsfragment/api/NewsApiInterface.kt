package com.example.newsfragment.api

import com.example.newsfragment.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApiInterface {

    @Headers("X-Api-Key: db71a7563e2445ac8093ac8034a97f4a") //http header
    @GET("top-headlines")
    fun getTopHeadLine(

        @Query("Category")category: String

    ): Call<News>
}
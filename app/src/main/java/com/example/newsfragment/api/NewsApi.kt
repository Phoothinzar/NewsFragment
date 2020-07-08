package com.example.newsfragment.api

import com.example.newsfragment.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//singleton
class NewsApi {

    private val newsApiInterface: NewsApiInterface

    companion object {
        const val BASE_URL = "http://newsapi.org/v2/"//instead of declaring in the main activity
    }

    init {
        //retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // obj neewsApiInterface = retrofit + api Interfaace
        newsApiInterface = retrofit.create(NewsApiInterface::class.java)

    }

    fun getTopHeadLine(category : String): Call<News>{
        return newsApiInterface.getTopHeadLine(category)
    }
}
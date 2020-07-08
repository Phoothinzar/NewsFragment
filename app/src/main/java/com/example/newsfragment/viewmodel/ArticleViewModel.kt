package com.example.newsfragment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsfragment.api.NewsApi
import com.example.newsfragment.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleViewModel : ViewModel() {

    //life data is immutable(val)
    //mutabledata (var) // can be change or add as you wish
    var results: MutableLiveData<News> = MutableLiveData()

    fun getResult(): LiveData<News> = results
    private val newsApi: NewsApi = NewsApi()
    fun loadResult(category: String) {
        val apiCall = newsApi.getTopHeadLine(category)
        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {


                response.isSuccessful.let {

                    val resultList = News(

                        response.body()?.articles ?: emptyList()
                    )
                    Log.d("Response",resultList.toString())

                    results.value = resultList
                }


            }
        })

    }

}


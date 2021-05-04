package com.example.youtubeapi.data.remote

import com.example.youtubeapi.`object`.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private lateinit var apiInstance: YoutubeApi

    fun getInstance():YoutubeApi{
        apiInstance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(YoutubeApi::class.java)
        return apiInstance
    }

}
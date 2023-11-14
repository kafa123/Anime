package com.example.anime

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeApiService {
    companion object{
        const val BASE_URL="https://api.jikan.moe/v4/"
    }
    private var retrofit:Retrofit?=null

    fun getInstance():Retrofit{
        if (retrofit==null){
            retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }
}
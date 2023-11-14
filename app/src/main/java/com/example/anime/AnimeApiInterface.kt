package com.example.anime

import android.telecom.Call
import retrofit2.http.GET

interface AnimeApiInterface {
    @GET("recommendations/anime")

    fun getAnimeList():retrofit2.Call<Animek>
}
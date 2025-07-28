package com.tami.tareas.View.menus.Noticias

import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



interface RetrofitNoticias {
    @GET("news")
    suspend fun getNews(
        @Query("apikey") apikey : String,
        @Query("country") country: String, // ✅ país
        @Query("language") language: String, // ✅ idioma
        @Query("category") category: String
    ): DataResponseNews
}


object RetrofitInstance {
    private const val BASE_URL = "https://newsdata.io/api/1/"

    val api: RetrofitNoticias  by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitNoticias::class.java)
    }
}
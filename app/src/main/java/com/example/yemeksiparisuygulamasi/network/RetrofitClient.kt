package com.example.yemeksiparisuygulamasi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://kasimadalan.pe.hu/yemekler/"

    val retrofit: YemeklerDao by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YemeklerDao::class.java)
    }
}

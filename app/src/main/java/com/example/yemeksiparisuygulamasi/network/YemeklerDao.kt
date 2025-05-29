package com.example.yemeksiparisuygulamasi.network

import com.example.yemeksiparisuygulamasi.model.YemeklerResponse
import retrofit2.http.GET

interface YemeklerDao {

    @GET("tumYemekleriGetir.php")
    suspend fun tumYemekleriGetir(): YemeklerResponse
}

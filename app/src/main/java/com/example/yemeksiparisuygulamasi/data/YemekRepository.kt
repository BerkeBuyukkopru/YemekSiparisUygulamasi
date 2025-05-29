package com.example.yemeksiparisuygulamasi.data

import com.example.yemeksiparisuygulamasi.model.Yemek
import com.example.yemeksiparisuygulamasi.network.RetrofitClient

class YemekRepository {

    private val yemeklerDao = RetrofitClient.retrofit

    suspend fun tumYemekleriGetir(): List<Yemek> {
        return yemeklerDao.tumYemekleriGetir().yemekler
    }
}

package com.example.yemeksiparisuygulamasi.data

import com.example.yemeksiparisuygulamasi.model.Siparis

object SiparisRepository {
    private val siparisler = mutableListOf<Siparis>()
    private var siparisSayaci = 1

    fun siparisEkle(yemekAdi: String, yemekResimAdi: String, adet: Int) {
        siparisler.add(Siparis(siparisSayaci++, yemekAdi, yemekResimAdi, adet))
    }

    fun tumSiparisler(): List<Siparis> = siparisler.toList()
}
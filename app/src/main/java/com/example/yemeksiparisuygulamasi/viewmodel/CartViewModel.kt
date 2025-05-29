package com.example.yemeksiparisuygulamasi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.model.Yemek

class CartViewModel : ViewModel() {

    private val _sepetYemekler = MutableLiveData<MutableList<Yemek>>(mutableListOf())
    val sepetYemekler: LiveData<MutableList<Yemek>> get() = _sepetYemekler

    fun sepeteEkle(yemek: Yemek) {
        val liste = _sepetYemekler.value ?: mutableListOf()
        val mevcutYemek = liste.find { it.yemekId == yemek.yemekId }
        if (mevcutYemek != null) {
            // Aynı yemek varsa adet arttır
            mevcutYemek.adet = mevcutYemek.adet + yemek.adet
        } else {
            // Yeni yemekse ekle
            liste.add(yemek)
        }
        _sepetYemekler.value = liste
    }

    fun adetGuncelle(yemekId: String, yeniAdet: Int) {
        val liste = _sepetYemekler.value ?: return
        val yemek = liste.find { it.yemekId == yemekId } ?: return
        yemek.adet = yeniAdet
        if (yemek.adet <= 0) {
            liste.remove(yemek)
        }
        _sepetYemekler.value = liste
    }

    fun sepettenKaldir(yemekId: String) {
        val liste = _sepetYemekler.value ?: return
        val yemek = liste.find { it.yemekId == yemekId } ?: return
        liste.remove(yemek)
        _sepetYemekler.value = liste
    }
    fun sepetiTemizle() {
        _sepetYemekler.value = mutableListOf()
    }

}
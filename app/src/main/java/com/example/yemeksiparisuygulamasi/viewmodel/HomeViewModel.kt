package com.example.yemeksiparisuygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemeksiparisuygulamasi.data.YemekRepository
import com.example.yemeksiparisuygulamasi.model.Yemek
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val yemekRepository = YemekRepository()
    val yemeklerListesi = MutableLiveData<List<Yemek>>()

    init {
        yemekleriYukle()
    }

    private fun yemekleriYukle() {
        viewModelScope.launch {
            try {
                val yemekler = yemekRepository.tumYemekleriGetir()
                yemeklerListesi.value = yemekler
                Log.d("HomeViewModel", "Yemekler: $yemekler")
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Hata: ${e.localizedMessage}")
            }
        }
    }
}

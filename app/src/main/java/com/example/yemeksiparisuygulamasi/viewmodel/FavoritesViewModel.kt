package com.example.yemeksiparisuygulamasi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.model.Yemek

class FavoritesViewModel : ViewModel() {

    private val _favoriYemekler = MutableLiveData<MutableList<Yemek>>().apply {
        value = mutableListOf()
    }
    val favoriYemekler: LiveData<MutableList<Yemek>> get() = _favoriYemekler

    fun favoriyeEkle(yemek: Yemek) {
        val currentList = _favoriYemekler.value ?: mutableListOf()
        if (!currentList.contains(yemek)) {
            currentList.add(yemek)
            _favoriYemekler.value = currentList
        }
    }

    fun favoridenKaldir(yemek: Yemek) {
        val currentList = _favoriYemekler.value ?: mutableListOf()
        currentList.remove(yemek)
        _favoriYemekler.value = currentList
    }
}


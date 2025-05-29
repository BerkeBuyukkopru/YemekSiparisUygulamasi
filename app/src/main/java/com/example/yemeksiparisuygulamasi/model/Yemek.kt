package com.example.yemeksiparisuygulamasi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Yemek(
    @SerializedName("yemek_id") val yemekId: String,
    @SerializedName("yemek_adi") val yemekAdi: String,
    @SerializedName("yemek_resim_adi") val yemekResimAdi: String,
    @SerializedName("yemek_fiyat") val yemekFiyat: String,
    var adet: Int = 1
) : Parcelable
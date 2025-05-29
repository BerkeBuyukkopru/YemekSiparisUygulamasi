package com.example.yemeksiparisuygulamasi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksiparisuygulamasi.databinding.ItemSepetBinding
import com.example.yemeksiparisuygulamasi.model.Yemek

class SepetAdapter(
    private val sepetYemekler: MutableList<Yemek>,
    private val onAdetArtir: (Yemek) -> Unit,
    private val onAdetAzalt: (Yemek) -> Unit,
    private val onYemekSil: (Yemek) -> Unit
) : RecyclerView.Adapter<SepetAdapter.SepetViewHolder>() {

    inner class SepetViewHolder(val binding: ItemSepetBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetViewHolder {
        val binding = ItemSepetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SepetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SepetViewHolder, position: Int) {
        val yemek = sepetYemekler[position]
        with(holder.binding) {
            textViewYemekAdi.text = yemek.yemekAdi
            textViewFiyat.text = "${yemek.yemekFiyat} ₺"
            textViewAdet.text = yemek.adet.toString()
            val total = yemek.adet * (yemek.yemekFiyat.toIntOrNull() ?: 0)
            textViewToplamFiyat.text = "$total ₺"

            val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemekResimAdi}"
            Glide.with(imageViewYemek.context).load(url).into(imageViewYemek)

            buttonArttir.setOnClickListener { onAdetArtir(yemek) }
            buttonAzalt.setOnClickListener { onAdetAzalt(yemek) }
            buttonSil.setOnClickListener { onYemekSil(yemek) }
        }
    }

    override fun getItemCount(): Int = sepetYemekler.size

    fun guncelle(newList: MutableList<Yemek>) {
        sepetYemekler.clear()
        sepetYemekler.addAll(newList)
        notifyDataSetChanged()
    }
}
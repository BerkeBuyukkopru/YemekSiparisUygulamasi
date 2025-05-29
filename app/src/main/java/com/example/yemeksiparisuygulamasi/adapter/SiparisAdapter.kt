package com.example.yemeksiparisuygulamasi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksiparisuygulamasi.databinding.ItemSiparisBinding
import com.example.yemeksiparisuygulamasi.model.Siparis

class SiparisAdapter(private var siparisListesi: List<Siparis>) : RecyclerView.Adapter<SiparisAdapter.SiparisViewHolder>() {

    inner class SiparisViewHolder(val binding: ItemSiparisBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiparisViewHolder {
        val binding = ItemSiparisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SiparisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SiparisViewHolder, position: Int) {
        val siparis = siparisListesi[position]
        holder.binding.textViewSiparisNo.text = "Sipariş No: ${siparis.siparisNo}"
        holder.binding.textViewYemekAdi.text = "${siparis.yemekAdi} (${siparis.adet} adet)"
        Glide.with(holder.binding.imageViewYemek.context)
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${siparis.yemekFotoUrl}")
            .into(holder.binding.imageViewYemek)
    }

    override fun getItemCount(): Int = siparisListesi.size

    fun submitList(yeniListe: List<Siparis>) {
        siparisListesi = yeniListe
        notifyDataSetChanged()
    }
}

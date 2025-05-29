package com.example.yemeksiparisuygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksiparisuygulamasi.databinding.ItemYemekBinding
import com.example.yemeksiparisuygulamasi.model.Yemek
import com.example.yemeksiparisuygulamasi.ui.home.HomeFragmentDirections

class YemeklerAdapter(
    private val yemekList: List<Yemek>,
    private val onItemClick: (Yemek) -> Unit,
    private val onDeleteClick: ((Yemek) -> Unit)? = null,
    private val showDeleteButton: Boolean = false
) : RecyclerView.Adapter<YemeklerAdapter.YemekViewHolder>() {

    inner class YemekViewHolder(val binding: ItemYemekBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemYemekBinding.inflate(inflater, parent, false)
        return YemekViewHolder(binding)
    }

    override fun onBindViewHolder(holder: YemekViewHolder, position: Int) {
        val yemek = yemekList[position]
        with(holder.binding) {
            textViewYemekAdi.text = yemek.yemekAdi
            textViewFiyat.text = "${yemek.yemekFiyat} ₺"
            val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemekResimAdi}"
            Glide.with(imageViewYemek.context).load(imageUrl).into(imageViewYemek)

            if (showDeleteButton && onDeleteClick != null) {
                buttonFavoridenKaldir.visibility = View.VISIBLE
                buttonFavoridenKaldir.setOnClickListener {
                    onDeleteClick.invoke(yemek)
                }
            } else {
                buttonFavoridenKaldir.visibility = View.GONE
                buttonFavoridenKaldir.setOnClickListener(null)
            }
        }

        holder.itemView.setOnClickListener {
            onItemClick(yemek)
        }
    }
    override fun getItemCount(): Int = yemekList.size
}


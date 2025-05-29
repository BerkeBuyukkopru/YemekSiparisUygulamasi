package com.example.yemeksiparisuygulamasi.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.yemeksiparisuygulamasi.databinding.FragmentDetailBinding
import com.example.yemeksiparisuygulamasi.model.Yemek
import com.example.yemeksiparisuygulamasi.viewmodel.CartViewModel
import com.example.yemeksiparisuygulamasi.viewmodel.FavoritesViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var secilenYemek: Yemek
    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesViewModel = ViewModelProvider(requireActivity())[FavoritesViewModel::class.java]
        cartViewModel = ViewModelProvider(requireActivity())[CartViewModel::class.java]

        arguments?.let {
            secilenYemek = DetailFragmentArgs.fromBundle(it).yemek
            binding.textViewYemekAdi.text = secilenYemek.yemekAdi
            binding.textViewFiyat.text = "${secilenYemek.yemekFiyat} ₺"

            val url = "http://kasimadalan.pe.hu/yemekler/resimler/${secilenYemek.yemekResimAdi}"
            Glide.with(requireContext()).load(url).into(binding.imageViewYemek)
        }

        binding.buttonFavorilereEkle.setOnClickListener {
            favoritesViewModel.favoriyeEkle(secilenYemek)
            Toast.makeText(requireContext(), "Favorilere eklendi", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSepeteEkle.setOnClickListener {
            secilenYemek.adet = binding.textViewAdet.text.toString().toInt()
            cartViewModel.sepeteEkle(secilenYemek)
            Toast.makeText(requireContext(), "${secilenYemek.yemekAdi} sepete eklendi.", Toast.LENGTH_SHORT).show()
        }

    }
}

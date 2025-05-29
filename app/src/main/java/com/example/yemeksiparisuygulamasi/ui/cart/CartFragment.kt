package com.example.yemeksiparisuygulamasi.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.adapter.SepetAdapter
import com.example.yemeksiparisuygulamasi.data.SiparisRepository
import com.example.yemeksiparisuygulamasi.databinding.FragmentCartBinding
import com.example.yemeksiparisuygulamasi.viewmodel.CartViewModel

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private val cartViewModel: CartViewModel by activityViewModels()
    private lateinit var adapter: SepetAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SepetAdapter(mutableListOf(),
            onAdetArtir = { yemek ->
                cartViewModel.adetGuncelle(yemek.yemekId, yemek.adet + 1)
            },
            onAdetAzalt = { yemek ->
                cartViewModel.adetGuncelle(yemek.yemekId, yemek.adet - 1)
            },
            onYemekSil = { yemek ->
                cartViewModel.sepettenKaldir(yemek.yemekId)
            }
        )

        binding.recyclerViewSepet.adapter = adapter
        binding.recyclerViewSepet.layoutManager = LinearLayoutManager(requireContext())

        cartViewModel.sepetYemekler.observe(viewLifecycleOwner) { sepetList ->
            adapter.guncelle(sepetList)

            // Toplam adet ve toplam tutarı hesapla
            val toplamAdet = sepetList.sumOf { it.adet }
            val toplamTutar = sepetList.sumOf { it.adet * it.yemekFiyat.toInt() }

            // TextView'ları güncelle
            binding.textViewToplamAdet.text = "Toplam Ürün: $toplamAdet"
            binding.textViewToplamTutar.text = "Toplam Tutar: $toplamTutar ₺"
        }

        binding.buttonSepetiOnayla.setOnClickListener {
            val sepetList = cartViewModel.sepetYemekler.value
            if (!sepetList.isNullOrEmpty()) {
                sepetList.forEach { yemek ->
                    SiparisRepository.siparisEkle(yemek.yemekAdi, yemek.yemekResimAdi, yemek.adet)
                }
                cartViewModel.sepetiTemizle()
                Toast.makeText(requireContext(), "Siparişiniz onaylandı!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Sepet boş!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
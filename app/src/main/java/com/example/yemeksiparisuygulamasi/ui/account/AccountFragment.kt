package com.example.yemeksiparisuygulamasi.ui.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.adapter.SiparisAdapter
import com.example.yemeksiparisuygulamasi.data.SiparisRepository
import com.example.yemeksiparisuygulamasi.databinding.FragmentAccountBinding
import com.example.yemeksiparisuygulamasi.model.Siparis

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    // Adapter değişkeni
    private lateinit var siparisAdapter: SiparisAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGirisYap.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        binding.recyclerViewGecmisSiparisler.layoutManager = LinearLayoutManager(requireContext())
        siparisAdapter = SiparisAdapter(listOf()) // boş liste ile başlat
        binding.recyclerViewGecmisSiparisler.adapter = siparisAdapter

        guncelleUI()
    }

    override fun onResume() {
        super.onResume()
        guncelleUI()
    }

    private fun guncelleUI() {
        val isimSoyisim = LoginFragment.kullaniciIsimSoyisim

        if (isimSoyisim.isNullOrEmpty()) {
            binding.buttonGirisYap.visibility = View.VISIBLE
            binding.textViewKullaniciAdi.visibility = View.GONE
            binding.textViewGecmisSiparislerBaslik.visibility = View.GONE
            binding.recyclerViewGecmisSiparisler.visibility = View.GONE
        } else {
            binding.buttonGirisYap.visibility = View.GONE
            binding.textViewKullaniciAdi.visibility = View.VISIBLE
            binding.textViewKullaniciAdi.text = isimSoyisim

            val siparisler: List<Siparis> = SiparisRepository.tumSiparisler()
            if (siparisler.isEmpty()) {
                binding.textViewGecmisSiparislerBaslik.visibility = View.GONE
                binding.recyclerViewGecmisSiparisler.visibility = View.GONE
            } else {
                binding.textViewGecmisSiparislerBaslik.visibility = View.VISIBLE
                binding.recyclerViewGecmisSiparisler.visibility = View.VISIBLE
                siparisAdapter.submitList(siparisler)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
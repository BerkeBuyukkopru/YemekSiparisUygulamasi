package com.example.yemeksiparisuygulamasi.ui.account

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    companion object {
        var kullaniciIsimSoyisim: String? = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonKaydet.setOnClickListener {
            val isim = binding.editTextIsim.text.toString().trim()
            val soyisim = binding.editTextSoyisim.text.toString().trim()

            if (isim.isEmpty() || soyisim.isEmpty()) {
                Toast.makeText(requireContext(), "Lütfen isim ve soyisim giriniz.", Toast.LENGTH_SHORT).show()
            } else {
                kullaniciIsimSoyisim = "$isim $soyisim"
                findNavController().navigateUp() // AccountFragment’a geri dön
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
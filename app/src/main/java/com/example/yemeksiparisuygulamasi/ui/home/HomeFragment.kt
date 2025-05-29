package com.example.yemeksiparisuygulamasi.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisuygulamasi.adapter.YemeklerAdapter
import com.example.yemeksiparisuygulamasi.databinding.FragmentHomeBinding
import com.example.yemeksiparisuygulamasi.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.yemeklerListesi.observe(viewLifecycleOwner) { yemekList ->
            val adapter = YemeklerAdapter(
                yemekList,
                onItemClick = { yemek ->
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(yemek)
                    Navigation.findNavController(binding.root).navigate(action)
                }
            )

            binding.recyclerViewYemekler.adapter = adapter
            binding.recyclerViewYemekler.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        return binding.root
    }
}

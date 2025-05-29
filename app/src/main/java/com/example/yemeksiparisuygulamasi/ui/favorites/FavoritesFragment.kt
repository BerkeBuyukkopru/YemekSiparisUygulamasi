package com.example.yemeksiparisuygulamasi.ui.favorites

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yemeksiparisuygulamasi.adapter.YemeklerAdapter
import com.example.yemeksiparisuygulamasi.databinding.FragmentFavoritesBinding
import com.example.yemeksiparisuygulamasi.viewmodel.FavoritesViewModel

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[FavoritesViewModel::class.java]

        viewModel.favoriYemekler.observe(viewLifecycleOwner) { favoriler ->
            val adapter = YemeklerAdapter(favoriler,
                onItemClick = { yemek ->
                    val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(yemek)
                    Navigation.findNavController(binding.root).navigate(action)
                },
                onDeleteClick = { yemek ->
                    viewModel.favoridenKaldir(yemek)
                },
                showDeleteButton = true
            )
            binding.recyclerViewFavoriler.adapter = adapter
            binding.recyclerViewFavoriler.layoutManager = GridLayoutManager(requireContext(), 3)
        }

        return binding.root
    }
}

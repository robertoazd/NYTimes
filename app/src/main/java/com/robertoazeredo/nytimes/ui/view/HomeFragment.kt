package com.robertoazeredo.nytimes.ui.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.robertoazeredo.nytimes.R
import com.robertoazeredo.nytimes.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.light_theme -> {
                    println("Light")
                    true
                }
                R.id.dark_theme -> {
                    println("Dark")
                    true
                }
                else -> false
            }
        }

        binding.buttonSections.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections
                .actionHomeFragmentToSectionsFragment())
        }
    }
}
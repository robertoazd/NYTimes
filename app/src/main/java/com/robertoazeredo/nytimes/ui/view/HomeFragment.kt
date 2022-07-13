package com.robertoazeredo.nytimes.ui.view

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.internal.ThemeEnforcement
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

            val sharedPreferences = requireContext().getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            when (menuItem.itemId) {
                R.id.light_theme -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    editor.putBoolean("MODE_NIGHT", false).apply()
                    true
                }
                R.id.dark_theme -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putBoolean("MODE_NIGHT", true).apply()
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
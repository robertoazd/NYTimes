package com.robertoazeredo.nytimes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.robertoazeredo.nytimes.databinding.FragmentSectionsBinding

class SectionsFragment : Fragment() {

    private lateinit var binding: FragmentSectionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.buttonWorld.setOnClickListener {
            println("World")
        }
        binding.buttonUs.setOnClickListener {
            println("Us")
        }
        binding.buttonPolitics.setOnClickListener {
            println("Politics")
        }
        binding.buttonNy.setOnClickListener {
            println("Ny")
        }
        binding.buttonBusiness.setOnClickListener {
            println("Business")
        }
        binding.buttonTech.setOnClickListener {
            println("Tech")
        }
        binding.buttonScience.setOnClickListener {
            println("Science")
        }
        binding.buttonSports.setOnClickListener {
            println("Sports")
        }
        binding.buttonBooks.setOnClickListener {
            println("Books")
        }
        binding.buttonFood.setOnClickListener {
            println("Food")
        }
        binding.buttonTravel.setOnClickListener {
            println("Travel")
        }
    }
}


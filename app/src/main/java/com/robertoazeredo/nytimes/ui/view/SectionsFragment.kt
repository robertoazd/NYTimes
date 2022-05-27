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
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("world")
            )
        }
        binding.buttonUs.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("us")
            )
        }
        binding.buttonPolitics.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("politics")
            )
        }
        binding.buttonNy.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("ny")
            )
        }
        binding.buttonBusiness.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("business")
            )
        }
        binding.buttonTech.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("tech")
            )
        }
        binding.buttonScience.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("science")
            )
        }
        binding.buttonSports.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("sports")
            )
        }
        binding.buttonArts.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("arts")
            )
        }
        binding.buttonBooks.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("books")
            )
        }
        binding.buttonFood.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("food")
            )
        }
        binding.buttonTravel.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("travel")
            )
        }
        binding.buttonGames.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("games")
            )
        }
        binding.buttonPodcasts.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("podcasts")
            )
        }
        binding.buttonJobs.setOnClickListener {
            findNavController().navigate(
                SectionsFragmentDirections
                    .actionSectionsFragmentToArticlesFragment("jobs")
            )
        }
    }
}


package com.robertoazeredo.nytimes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.robertoazeredo.nytimes.databinding.FragmentArticlesBinding
import com.robertoazeredo.nytimes.ui.viewmodel.NewsViewModel

class ArticlesFragment : Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private val args: ArticlesFragmentArgs by navArgs()

    private val viewModel: NewsViewModel by lazy {
        ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObservables()
        viewModel.getNews(section = args.section)
    }

    private fun setupView() {
        binding.textSection.text = args.section
    }

    private fun setupObservables() {
        viewModel.articles.observe(viewLifecycleOwner) { articles ->
            if (!articles.isNullOrEmpty()) {
                println(articles)
            }
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            println(errorMessage)
        }
    }
}
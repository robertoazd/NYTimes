package com.robertoazeredo.nytimes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.robertoazeredo.nytimes.databinding.FragmentArticlesBinding
import com.robertoazeredo.nytimes.ui.adapter.ArticlesAdapter
import com.robertoazeredo.nytimes.ui.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment : Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private val args: ArticlesFragmentArgs by navArgs()

    private val viewModel: NewsViewModel by viewModels()

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
        setupListeners()
        setupObservables()
        viewModel.getNews(section = args.section)
    }

    private fun setupView() {
        binding.textSection.text = args.section
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupObservables() {
        viewModel.articles.observe(viewLifecycleOwner) { articles ->
            if (!articles.isNullOrEmpty()) {
                val articlesAdapter = ArticlesAdapter(articles = articles, onItemClick = { article ->
                    findNavController().navigate(ArticlesFragmentDirections
                        .actionArticlesFragmentToArticleDetailFragment(article))
                })
                binding.recyclerArticles.adapter = articlesAdapter

                binding.progressBar.visibility = View.INVISIBLE
                binding.scrollSection.visibility = View.VISIBLE
            }
        }
        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            binding.textError.setText(errorMessage)

            binding.progressBar.visibility = View.INVISIBLE
            binding.textError.visibility = View.VISIBLE
        }
    }
}
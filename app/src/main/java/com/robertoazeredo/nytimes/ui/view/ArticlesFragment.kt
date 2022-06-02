package com.robertoazeredo.nytimes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.robertoazeredo.nytimes.data.model.NewsResponse
import com.robertoazeredo.nytimes.data.repository.NewsRepository
import com.robertoazeredo.nytimes.databinding.FragmentArticlesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesFragment : Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private val args: ArticlesFragmentArgs by navArgs()

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
        getNews()
    }

    private fun setupView() {
        binding.textSection.text = args.section
    }

    private fun getNews() {
        NewsRepository().getNews(args.section).enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                println(response)
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                println(t)
            }
        })
    }
}
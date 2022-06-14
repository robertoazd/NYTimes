package com.robertoazeredo.nytimes.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.robertoazeredo.nytimes.databinding.FragmentArticleDetailBinding
import com.robertoazeredo.nytimes.util.DateFormat

class ArticleDetailFragment : Fragment() {

    private lateinit var binding: FragmentArticleDetailBinding
    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupListeners()
    }

    private fun setupView() {
        val article = args.article

        binding.textSection.text = article.section

        binding.textSubsection.text = article.subsection

        binding.textTitle.text = article.title

        val articleImage = article.multimedia?.first { multimedia ->
            multimedia.format == "mediumThreeByTwo440"
        }

        if (articleImage?.url != null) {
            Glide
                .with(binding.root.context)
                .load(articleImage.url)
                .centerCrop()
                .into(binding.imageThumbnailStandard)
        } else {
            binding.imageThumbnailStandard.visibility = View.GONE
        }

        val articleCaption = article.multimedia?.first()?.caption

        if (articleCaption.isNullOrEmpty()) {
            binding.textCaption.text = articleCaption
        } else {
            binding.groupCaption.visibility = View.GONE
        }


        val articleCopyright = article.multimedia?.first()?.copyright

        if (articleCopyright.isNullOrEmpty()) {
            binding.textCopyright.text = articleCopyright
        } else {
            binding.groupCaption.visibility = View.GONE
        }


        if (!article.abstract.isNullOrEmpty()) {
            binding.textAbstract.text = article.abstract
        } else {
            binding.textAbstract.visibility = View.GONE
        }

        val formattedDate = article.publishedDate?.let { DateFormat.getDate(it) }
        binding.textPublishedDate.text = formattedDate

        if (!article.byline.isNullOrEmpty()) {
            binding.textByline.text = article.byline
        } else {
            binding.groupByline.visibility = View.GONE
        }
    }

    private fun setupListeners() {

    }
}
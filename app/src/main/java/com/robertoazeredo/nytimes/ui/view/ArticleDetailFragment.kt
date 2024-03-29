package com.robertoazeredo.nytimes.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        if (!article.subsection.isNullOrEmpty()) {
            binding.textSubsection.text = article.subsection
        } else {
            binding.textSubsection.visibility = View.GONE
        }

        binding.textTitle.text = article.title

        val articleImage = article.multimedia?.firstOrNull { multimedia ->
            multimedia.format == "mediumThreeByTwo440"
        }

        if (articleImage?.url != null) {
            Glide
                .with(binding.root.context)
                .load(articleImage.url)
                .centerCrop()
                .into(binding.imageThumbnailStandard)

            val articleCaption = article.multimedia.first().caption
            val articleCopyright = article.multimedia.first().copyright

            if (!articleCaption.isNullOrEmpty() && !articleCopyright.isNullOrEmpty()) {

                val spannableString = SpannableString("$articleCaption $articleCopyright")
                spannableString.setSpan(
                    RelativeSizeSpan(0.75.toFloat()),
                    articleCaption.length,
                    articleCaption.length + articleCopyright.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                binding.textCaption.text = spannableString
            } else {
                binding.textCaption.visibility = View.GONE
            }
        } else {
            binding.groupImage.visibility = View.GONE
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
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonUrl.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(args.article.url))
            ContextCompat.startActivity(requireContext(), browserIntent, null)
        }
    }
}
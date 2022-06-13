package com.robertoazeredo.nytimes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.robertoazeredo.nytimes.data.model.Article
import com.robertoazeredo.nytimes.databinding.ItemArticleBinding
import com.robertoazeredo.nytimes.util.DateFormat

class ArticlesAdapter(
    private val articles: List<Article>,
    private val onItemClick: (article: Article) -> Unit
) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleBinding.inflate(layoutInflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position], onItemClick)
    }

    override fun getItemCount() = articles.size

    class ArticleViewHolder(
        private val binding: ItemArticleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, onItemClick: (article: Article) -> Unit) {

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

            binding.textTitle.text = article.title

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

            binding.root.setOnClickListener {
                onItemClick.invoke(article)
            }
        }
    }
}
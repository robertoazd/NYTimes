package com.robertoazeredo.nytimes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robertoazeredo.nytimes.data.model.Article
import com.robertoazeredo.nytimes.databinding.ItemArticleBinding

class ArticlesAdapter(
    private val articles: List<Article>
) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleBinding.inflate(layoutInflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount() = articles.size

    class ArticleViewHolder(
        private val binding: ItemArticleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.textTitle.text = article.title
            binding.textAbstract.text = article.abstract
            binding.textPublishedDate.text = article.publishedDate
            binding.textByline.text = article.byline
        }
    }
}
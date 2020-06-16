package com.poilkar.nehank.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.AsyncListUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poilkar.nehank.newsapp.R
import com.poilkar.nehank.newsapp.model.Article
import kotlinx.android.synthetic.main.row_news_article.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_news_article,parent,false)
        return ArticleViewHolder((view))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener :((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentArticle = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(currentArticle.urlToImage).into(ivArticleImage)
            tvSource.text = currentArticle.source?.name
            tvTitle.text = currentArticle.title
            tvDescription.text = currentArticle.description
            tvPublishedAt.text = currentArticle.publishedAt

            setOnClickListener {
                onItemClickListener?.let {
                    it(currentArticle)
                }
            }
        }
    }



    fun setOnItemClickListener(listener: (Article) -> Unit){
        onItemClickListener = listener
    }
}
package com.example.newsfragment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfragment.R
import com.example.newsfragment.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter (var articleList: List<Article> = ArrayList()):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent,false)
        return ArticleViewHolder(view)

    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindArticle(articleList.get(position))
    }

    fun updateList(article: List<Article>){
        this.articleList=article
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView){

    fun bindArticle (article: Article){
        Picasso.get()
            .load(article.urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .into(itemView.articalImage)
        itemView.articleTitle.text=article.title
        itemView.articleDescription.text=article.description


    }

}}
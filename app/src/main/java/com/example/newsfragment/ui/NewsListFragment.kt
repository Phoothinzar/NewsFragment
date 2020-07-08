package com.example.newsfragment.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.newsfragment.R
import com.example.newsfragment.ui.adapter.NewsAdapter
import com.example.newsfragment.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.fragment_news_list.*

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment() {
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var articleViewModel: ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        newsAdapter = NewsAdapter()
        recyclerNews.apply {
            adapter = newsAdapter
            layoutManager = viewManager
            observeViewModel()

        }

    }

    fun observeViewModel() {
        articleViewModel = ViewModelProvider(this)
            .get(ArticleViewModel::class.java)

        articleViewModel.getResult().observe(
            viewLifecycleOwner, Observer { result ->
                newsAdapter.updateList(result.articles)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        articleViewModel.loadResult("technology")
    }


}

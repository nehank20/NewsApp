package com.poilkar.nehank.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.poilkar.nehank.newsapp.R
import com.poilkar.nehank.newsapp.db.ArticleDatabase
import com.poilkar.nehank.newsapp.repo.NewsRepository
import com.poilkar.nehank.newsapp.util.NewsViewModel
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val newsRepositoryFactory = NewsViewModelProviderFactory(newsRepository)

        viewModel = ViewModelProvider(this,newsRepositoryFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}
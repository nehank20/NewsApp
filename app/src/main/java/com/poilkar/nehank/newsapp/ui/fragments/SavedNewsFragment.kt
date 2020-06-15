package com.poilkar.nehank.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.poilkar.nehank.newsapp.R
import com.poilkar.nehank.newsapp.ui.NewsActivity
import com.poilkar.nehank.newsapp.util.NewsViewModel

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    lateinit var viewmodel : NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = (activity as NewsActivity).viewModel
    }
}
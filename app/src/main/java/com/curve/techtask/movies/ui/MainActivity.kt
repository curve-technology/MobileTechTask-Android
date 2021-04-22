package com.curve.techtask.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.curve.techtask.data.repository.Movie
import com.curve.techtask.movies.R
import com.curve.techtask.movies.ui.adapter.MovieListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MoviesViewModel by viewModel()
    private val adapter by lazy { MovieListAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        startObervers()
        viewModel.init()
    }

    private fun startObervers() {
        viewModel.moviesSource.observeForever {
            updateMovies(it)
        }
        viewModel.errors.observeForever {
            viewModel.showError(this, it)
        }
    }

    private fun updateMovies(movies: List<Movie>) {
        adapter.submitList(movies)
    }

    private fun setupUI() {
        title = "Popular Movies"
        movies_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        movies_list.adapter = adapter
    }

}
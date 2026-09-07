package com.curve.techtask.movies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.curve.techtask.data.repository.Movie
import com.curve.techtask.movies.databinding.ActivityMainBinding
import com.curve.techtask.movies.ui.adapter.MovieListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MoviesViewModel by viewModel()
    private val adapter by lazy { MovieListAdapter() }
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        startObervers()
        viewModel.init()
    }

    private fun startObervers() {
        viewModel.moviesSource.observe(this) {
            updateMovies(it)
        }
        viewModel.errors.observe(this) {
            viewModel.showError(this, it)
        }
    }

    private fun updateMovies(movies: List<Movie>) {
        adapter.submitList(movies)
    }

    private fun setupUI() {
        title = "Popular Movies"
        binding.moviesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.moviesList.adapter = adapter
    }

}

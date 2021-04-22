package com.curve.techtask.movies.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curve.techtask.data.repository.Movie
import com.curve.techtask.data.repository.MoviesRepository
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class MoviesViewModel(private val repository : MoviesRepository) : ViewModel() {

    val moviesSource : MutableLiveData<List<Movie>> = MutableLiveData()
    val errors : MutableLiveData<String> = MutableLiveData()

    fun init() {
        viewModelScope.launch {
            repository.getMovies()?.let {
                displayMovies(it)
            } ?: errors.setValue("Couldn't fetch movies!")
        }
    }

    private fun displayMovies(movies: List<Movie>) {
        moviesSource.value = movies
    }

    fun showError(context: Context, message: String) {
        MaterialAlertDialogBuilder(context)
            .setTitle("Something went wrong!")
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, null)
            .show()
    }

}
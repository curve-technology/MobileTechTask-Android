package com.curve.techtask.data.repository

class MoviesRepository(val dataSource: MoviesDataSource) {

    suspend fun getMovies(): List<Movie>? {
        val response = dataSource.getMovies()

        return if (response.isSuccessful) {
            response.body()?.results
        } else {
            null
        }
    }

}
package com.curve.techtask.data.repository

import com.squareup.moshi.Json


data class MoviesResponseJson(
    val page: Long,
    val results: List<Movie>,
    @Json(name = "total_results") val totalResults: Long,
    @Json(name = "total_pages") val totalPages: Long
)

data class Movie(
    @Json(name = "poster_path") val posterPath: String,
    val adult: Boolean,
    val overview: String,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "genre_ids") val genreIDS: List<Long>,
    val id: Long,
    @Json(name = "original_title") val originalTitle: String,
    @Json(name = "original_language") val originalLanguage: String,
    val title: String,
    @Json(name = "backdrop_path") val backdropPath: String,
    val popularity: Double,
    @Json(name = "vote_count") val voteCount: Long,
    val video: Boolean,
    @Json(name = "vote_average") val voteAverage: Double
)
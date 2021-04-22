package com.curve.techtask.data.repository

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesDataSource {

    @GET("/3/movie/popular?api_key=d9eb776715ce8a656d730e7e40ec61ab")
    suspend fun getMovies(@Query("language") language: String = "en-US", @Query("page") page: Int = 1): Response<MoviesResponseJson>

}
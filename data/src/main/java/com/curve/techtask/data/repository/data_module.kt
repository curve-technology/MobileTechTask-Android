package com.curve.techtask.data.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val data_module = module {
    single { get<Retrofit>().create(MoviesDataSource::class.java) }
    single { MoviesRepository(get()) }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }
    factory { Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build() }
}
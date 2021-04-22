package com.curve.techtask.movies.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation_module = module {
    viewModel { MoviesViewModel(get()) }
}
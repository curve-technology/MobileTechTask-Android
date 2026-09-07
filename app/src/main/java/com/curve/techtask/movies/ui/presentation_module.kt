package com.curve.techtask.movies.ui

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentation_module = module {
    viewModelOf(::MoviesViewModel)
}

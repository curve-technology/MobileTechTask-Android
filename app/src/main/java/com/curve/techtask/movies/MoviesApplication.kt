package com.curve.techtask.movies

import android.app.Application
import com.curve.techtask.data.repository.data_module
import com.curve.techtask.movies.ui.presentation_module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MoviesApplication)
            modules(presentation_module, data_module)
        }
    }
}

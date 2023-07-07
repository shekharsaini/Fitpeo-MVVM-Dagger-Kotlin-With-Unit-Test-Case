package com.example.fitpeo

import android.app.Application
import com.squareup.picasso.Picasso
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FitPeoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Picasso.setSingletonInstance(Picasso.Builder(this).build())

    }
}
package com.example.fitpeo.di

import android.content.Context
import androidx.room.Room
import com.example.fitpeo.db.FitPeoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFitPeoDB(@ApplicationContext context : Context) : FitPeoDB{
        return Room.databaseBuilder(context, FitPeoDB::class.java, "FitPeoDB").build()
    }
}
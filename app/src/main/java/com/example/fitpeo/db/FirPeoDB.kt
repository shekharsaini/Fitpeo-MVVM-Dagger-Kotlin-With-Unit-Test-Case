package com.example.fitpeo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitpeo.models.Photo

@Database(entities = [Photo::class], version = 1)
abstract class FitPeoDB : RoomDatabase() {

    abstract fun getFakerDAO() : FitPeoDao

}
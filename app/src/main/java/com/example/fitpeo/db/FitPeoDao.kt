package com.example.fitpeo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitpeo.models.Photo

@Dao
interface FitPeoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPhotos(photo: List<Photo>)

    @Query("SELECT * FROM Photo")
    suspend fun getPhotos() : List<Photo>

}
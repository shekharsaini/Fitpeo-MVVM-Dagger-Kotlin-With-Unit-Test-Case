package com.example.fitpeo.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Photo(
    val albumId: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,

) : Serializable
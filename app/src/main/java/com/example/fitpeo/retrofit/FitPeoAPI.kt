package com.example.fitpeo.retrofit

import retrofit2.Response
import retrofit2.http.GET
import com.example.fitpeo.models.Photo

interface FitPeoAPI {

    @GET("photos")
    suspend fun getPhotos() : Response<List<Photo>>

}
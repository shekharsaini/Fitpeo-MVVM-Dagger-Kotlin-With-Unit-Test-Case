package com.example.fitpeo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fitpeo.db.FitPeoDB
import com.example.fitpeo.models.Photo
import com.example.fitpeo.retrofit.FitPeoAPI
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val fitPeoAPI: FitPeoAPI, private val fitPeoDB: FitPeoDB) {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos : LiveData<List<Photo>>
        get() = _photos

    suspend fun getPhotos(): List<Photo>{
        val result = fitPeoAPI.getPhotos()
        if(result.isSuccessful && result.body() != null){
            fitPeoDB.getFakerDAO().addPhotos(result.body()!!)
            _photos.postValue(result.body())
        }
        return result.body()!!
    }

}
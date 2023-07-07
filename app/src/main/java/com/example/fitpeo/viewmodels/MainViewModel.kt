package com.example.fitpeo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitpeo.models.Photo
import com.example.fitpeo.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PhotoRepository) : ViewModel() {
    val photosLiveData : LiveData<List<Photo>> get() = repository.photos
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> get() = _photos

    /*init {
        viewModelScope.launch {
            delay(10000)
            repository.getPhotos()
        }
    }*/
    fun fetchPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = repository.getPhotos()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}
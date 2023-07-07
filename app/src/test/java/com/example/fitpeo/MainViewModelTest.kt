package com.example.fitpeo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.fitpeo.models.Photo
import com.example.fitpeo.repository.PhotoRepository
import com.example.fitpeo.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class MainViewModelTest {
    val dispatcher = TestCoroutineDispatcher()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var photoRepository: PhotoRepository

    private lateinit var photoViewModel: MainViewModel


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        photoViewModel = MainViewModel(photoRepository)
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    // Using Observer

   /* @Test
    fun `fetchPhotos should update photos LiveData`() {
        // Create a list of photos to be returned by the repository
        val photos = listOf(
            Photo(1, 1, "title1","https://via.placeholder.com/600/92c952", "https://via.placeholder.com/150/92c952"),
            Photo(1, 2, "title2","https://via.placeholder.com/600/771796", "https://via.placeholder.com/150/771796")
        )

        // Mock the repository's getPhotos function to return the predefined list of photos
        runBlocking {
            Mockito.`when`(photoRepository.getPhotos()).thenReturn(photos)
        }

        // Create a mock Observer to capture the emitted LiveData value
        val observer = Observer<List<Photo>> { capturedPhotos ->
            // Perform assertions to compare the captured list with the expected list
            assertThat(capturedPhotos,photos)
        }

        try {
            // Observe the LiveData using the mock Observer
            photoViewModel.photos.observeForever(observer)

            // Call the fetchPhotos function to trigger the API call and update the LiveData
            photoViewModel.fetchPhotos()
        } finally {
            // Remove the observer to avoid memory leaks
            photoViewModel.photos.removeObserver(observer)
        }
    }*/




    @Test
    fun `fetchPhotos should update photos LiveData`() = runBlocking {
        val photos = listOf(
            Photo(1, 1, "title1","url1", "thumbnailUrl1"),
            Photo(2, 2, "title2","url2", "thumbnailUrl2")
        )
        Mockito.`when`(photoRepository.getPhotos()).thenReturn(photos)

        photoViewModel.fetchPhotos()
        assertThat(photoViewModel.photos.value,photos)

    }

    private fun assertThat(actual: List<Photo>?, expected: List<Photo>) {
        //assert(expected == actual)

        // or

        assertThat(actual, equalTo(expected))
    }

}
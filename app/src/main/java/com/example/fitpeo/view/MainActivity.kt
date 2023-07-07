package com.example.fitpeo.view

import android.app.Activity
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitpeo.DetailActivity
import com.example.fitpeo.PhotoAdapter
import com.example.fitpeo.R
import com.example.fitpeo.databinding.ActivityMainBinding
import com.example.fitpeo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var photoAdapter: PhotoAdapter
    lateinit var mainViewModel: MainViewModel
    private lateinit var activity: Activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        activity = this@MainActivity
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        setupRecyclerView()
        mainViewModel.fetchPhotos()
        observeViewModel()
    }
    private fun setupRecyclerView() {
        photoAdapter = PhotoAdapter(PhotoAdapter.OnClickListener {
           photo ->
            val bundle = Bundle()
            bundle.putString("title", photo.title)
            bundle.putString("url", photo.url)
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })
        binding.recyclerView.apply {
            adapter = photoAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeViewModel() {
        mainViewModel.photosLiveData.observe(this, Observer {
            photoAdapter.submitList(it)
            binding.pbProgress.visibility = View.GONE
        })
    }

}


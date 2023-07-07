package com.example.fitpeo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fitpeo.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val bundle = intent.extras
        if (bundle != null){
            binding.titleTextView.text = "${bundle.getString("title")}"
            Picasso.get().load("${bundle.getString("url")}").placeholder(R.drawable.app_icon)
                .error(R.drawable.ic_launcher_background)
                .into(binding.headerImageView);
        }
    }

}
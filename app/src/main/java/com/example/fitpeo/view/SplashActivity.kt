package com.example.fitpeo.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.fitpeo.R
import com.example.fitpeo.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var _binding: ActivitySplashBinding
    private val binding get() = _binding!!
    private lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        supportActionBar?.hide()
        activity = this@SplashActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }, 3000)

    }
}
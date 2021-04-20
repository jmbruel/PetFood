package com.mexator.petfoodinspector.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mexator.petfoodinspector.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
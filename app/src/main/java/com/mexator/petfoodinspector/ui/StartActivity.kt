package com.mexator.petfoodinspector.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mexator.petfoodinspector.R
import com.mexator.petfoodinspector.data.Repository
import com.mexator.petfoodinspector.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }

    private val repo = Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            repo.login()
            val intent = Intent(this, AuthorizedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
package com.mexator.petfoodinspector.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mexator.petfoodinspector.R
import com.mexator.petfoodinspector.data.Repository
import com.mexator.petfoodinspector.databinding.ActivityAuthorizedBinding

class AuthorizedActivity : AppCompatActivity(R.layout.activity_authorized) {
    private val binding: ActivityAuthorizedBinding by lazy {
        ActivityAuthorizedBinding.inflate(layoutInflater)
    }

    private val repo = Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = repo.getUser()

        binding.loginView.text =
            resources.getString(R.string.login_placeholder, user.login)
        binding.passwordView.text =
            resources.getString(R.string.password_placeholder, user.password)

    }
}
package com.mexator.petfoodinspector.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.mexator.petfoodinspector.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }
    private val navController by lazy {
        Navigation.findNavController(binding.fragmentContainer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
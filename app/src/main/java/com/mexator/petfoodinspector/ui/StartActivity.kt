package com.mexator.petfoodinspector.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.mexator.petfoodinspector.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
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
        setupActionBarWithNavController(navController, AppBarConfiguration(navController.graph))
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.popBackStack()
        return super.onSupportNavigateUp()
    }
}
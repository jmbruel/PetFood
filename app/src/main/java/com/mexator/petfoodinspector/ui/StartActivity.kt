package com.mexator.petfoodinspector.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.mexator.petfoodinspector.R
import com.mexator.petfoodinspector.data.Repository
import com.mexator.petfoodinspector.databinding.ActivityStartBinding
import com.mexator.petfoodinspector.ui.foodlist.FoodListPageFragment

class StartActivity : AppCompatActivity() {
    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }

    private val repo = Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
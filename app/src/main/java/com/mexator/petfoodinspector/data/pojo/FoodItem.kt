package com.mexator.petfoodinspector.data.pojo

import com.mexator.petfoodinspector.data.DangerLevel
import com.mexator.petfoodinspector.ui.data.FoodPicture

data class FoodItem(
    val id: Int,
    val name: String,
    val dangerLevel: DangerLevel,
    val imageData: FoodPicture
)

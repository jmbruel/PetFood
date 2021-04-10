package com.mexator.petfoodinspector.data.pojo

import com.mexator.petfoodinspector.data.DangerLevel

data class FoodItem(
    val id: Int,
    val name: String,
    val dangerLevel: DangerLevel,
    val imageUrl: String?
)

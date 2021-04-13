package com.mexator.petfoodinspector.data.pojo

import com.mexator.petfoodinspector.data.DangerLevel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class FoodItem(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val name: String,
    @SerialName("category")
    private val category: String,
    val imageUrl: String? = null
) {
    @Transient
    val dangerLevel: DangerLevel = when (category) {
        "safe" -> DangerLevel.Safe
        "prohibited" -> DangerLevel.Danger
        "with_care" -> DangerLevel.Treat
        else -> error("Cannot deserialize: unknown category: $category")
    }
}

package com.mexator.petfoodinspector.data.local

import com.mexator.petfoodinspector.data.DangerLevel
import com.mexator.petfoodinspector.data.pojo.FoodDetail
import com.mexator.petfoodinspector.data.pojo.FoodItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.io.FileDescriptor

@Serializable
class LocalFoodItem(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val name: String,
    @SerialName("category")
    private val category: String,
    @SerialName("details")
    private val description: String
) {
    @Transient
    private val imageUrl: String = "$id.jpg"

    fun toFoodItem(): FoodItem {
        val dangerLevel: DangerLevel = when (category) {
            "safe" -> DangerLevel.Safe
            "prohibited" -> DangerLevel.Danger
            "with_care" -> DangerLevel.Treat
            else -> error("Cannot deserialize: unknown category: $category")
        }
        return FoodItem(id, name, dangerLevel, imageUrl)
    }

    fun toFoodDetail(): FoodDetail {
        return FoodDetail(
            toFoodItem(),
            description
        )
    }
}

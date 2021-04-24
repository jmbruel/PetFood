package com.mexator.petfoodinspector.data.network.dto

import com.mexator.petfoodinspector.domain.data.DangerLevel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RemoteFoodItem(
    @SerialName("id")
    val id: Int,
    @SerialName("productName")
    val name: String,
    @SerialName("productImageUrl")
    val imageUrl: String,
    @SerialName("productDangLevel")
    val dangerLevel: DangerLevel,
    @SerialName("productDescription")
    val productDescription: String
)
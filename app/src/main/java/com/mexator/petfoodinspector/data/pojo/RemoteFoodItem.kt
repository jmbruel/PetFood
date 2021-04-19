package com.mexator.petfoodinspector.data.pojo

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
    // TODO make it an enum
    val dangerLevel: Int,
    @SerialName("productDescription")
    val productDescription: String
)
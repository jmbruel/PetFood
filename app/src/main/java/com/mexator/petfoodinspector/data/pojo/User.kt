package com.mexator.petfoodinspector.data.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserAuth(
    @SerialName("email")
    val login: String,
    @SerialName("password")
    val password: String
)

@Serializable
data class User(
    @SerialName("id")
    val id: Int,
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val passHash: String,
    @SerialName("token")
    val token: String
)
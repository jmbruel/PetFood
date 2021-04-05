package com.mexator.petfoodinspector.data

import com.mexator.petfoodinspector.data.pojo.User

object Repository {
    private var isLoggedIn: Boolean = false

    fun login() {
        isLoggedIn = true
    }

    fun getUser(): User {
        if (isLoggedIn) return User("Antoxa","passw0rd")
        throw IllegalAccessError("User is not authenticated")
    }
}
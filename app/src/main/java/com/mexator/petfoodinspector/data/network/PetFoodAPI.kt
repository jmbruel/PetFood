package com.mexator.petfoodinspector.data.network

import com.mexator.petfoodinspector.data.pojo.RemoteFoodItem
import com.mexator.petfoodinspector.data.pojo.User
import com.mexator.petfoodinspector.data.pojo.UserAuth
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Defines API calls that app makes to server
 */
interface PetFoodAPI {
    @POST("account/signup")
    fun signUp(@Body authData: UserAuth): Single<User>

    @POST("account/login")
    fun logIn(@Body authData: UserAuth): Single<User>

    @GET("products/products")
    fun getProducts(): Single<List<RemoteFoodItem>>
}
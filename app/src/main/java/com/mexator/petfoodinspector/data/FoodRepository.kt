package com.mexator.petfoodinspector.data

import com.mexator.petfoodinspector.data.pojo.FoodDetail
import com.mexator.petfoodinspector.data.pojo.FoodItem
import io.reactivex.rxjava3.core.Single

typealias FoodID = Int

/**
 * Abstract data source, capable of returning list of food items
 */
interface FoodRepository {

    fun getFoodList(): Single<List<FoodItem>>

    fun getDetail(id: FoodID): Single<FoodDetail>
}
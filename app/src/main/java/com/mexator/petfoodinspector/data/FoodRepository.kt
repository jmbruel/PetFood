package com.mexator.petfoodinspector.data

import com.mexator.petfoodinspector.data.pojo.FoodItem
import io.reactivex.rxjava3.core.Single

/**
 * Abstract data source, capable of returning list of food items
 */
interface FoodRepository {
    fun getFoodList(): Single<List<FoodItem>>
}
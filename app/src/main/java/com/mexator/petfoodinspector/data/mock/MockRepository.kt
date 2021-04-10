package com.mexator.petfoodinspector.data.mock

import com.mexator.petfoodinspector.data.DangerLevel
import com.mexator.petfoodinspector.data.FoodRepository
import com.mexator.petfoodinspector.data.pojo.FoodItem
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

object MockRepository : FoodRepository {
    private val urls = listOf<String>(
        "https://public-media.si-cdn.com/filer/d5/24/d5243019-e0fc-4b3c-8cdb-48e22f38bff2/istock-183380744.jpg",
        "https://cdn.britannica.com/75/174375-050-BC6968AE/Hazelnuts-fruit-compound-ovary-seed.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/7/70/Chocolate_%28blue_background%29.jpg",
    )
    private var id: Int = 1
        get() = field++

    private val foods = listOf<FoodItem>(
        FoodItem(id, "Banana", DangerLevel.Treat, urls[0]),
        FoodItem(id, "Nut", DangerLevel.Safe, urls[1]),
        FoodItem(id, "Chocolate", DangerLevel.Danger, urls[2]),
        FoodItem(
            id,
            "Item with very, very, very, very, very, very, very, very, very, very, very long name",
            DangerLevel.Danger,
            urls[2]
        ),
    )

    override fun getFoodList(): Single<List<FoodItem>> =
        Single.just(foods)
            .delay(500, TimeUnit.MILLISECONDS)
}
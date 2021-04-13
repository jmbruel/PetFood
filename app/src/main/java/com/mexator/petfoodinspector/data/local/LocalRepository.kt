package com.mexator.petfoodinspector.data.local

import android.content.Context
import com.mexator.petfoodinspector.data.FoodID
import com.mexator.petfoodinspector.data.FoodRepository
import com.mexator.petfoodinspector.data.pojo.FoodDetail
import com.mexator.petfoodinspector.data.pojo.FoodItem
import io.reactivex.rxjava3.core.Single
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream
import java.io.InputStream

object LocalRepository : FoodRepository {
    private const val DATA_FILENAME = "data.json"
    private val json = Json { ignoreUnknownKeys = true }

    private lateinit var appContext: Context
    fun provideAppContext(context: Context) {
        appContext = context
    }

    override fun getFoodList(): Single<List<FoodItem>> {
        val assets = appContext.assets
        val foodsJSON = assets.open(DATA_FILENAME).readToString()
        return Single.just(json.decodeFromString<List<FoodItem>>(foodsJSON))
    }

    override fun getDetail(id: FoodID): Single<FoodDetail> {
        TODO("Not yet implemented")
    }

    private fun InputStream.readToString(): String {
        val result = ByteArrayOutputStream()
        val buffer = ByteArray(1024)
        var length: Int
        while (read(buffer).also { length = it } != -1) {
            result.write(buffer, 0, length)
        }
        return result.toString("UTF-8")
    }
}
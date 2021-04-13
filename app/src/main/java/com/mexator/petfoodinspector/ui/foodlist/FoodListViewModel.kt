package com.mexator.petfoodinspector.ui.foodlist

import androidx.lifecycle.ViewModel
import com.mexator.petfoodinspector.data.FoodRepository
import com.mexator.petfoodinspector.data.local.LocalRepository
import com.mexator.petfoodinspector.data.mock.MockRepository
import com.mexator.petfoodinspector.data.pojo.FoodItem
import com.mexator.petfoodinspector.ui.foodlist.recycler.FoodUI
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.*

class FoodListViewModel : ViewModel() {
    data class FoodListViewState(
        val progress: Boolean = false,
        val displayedItems: List<FoodUI> = listOf(),
    )

    private val searchQueries: BehaviorSubject<String> = BehaviorSubject.create()
    private val foodListObservable: PublishSubject<List<FoodItem>> = PublishSubject.create()
    private val progressObservable: PublishSubject<Boolean> = PublishSubject.create()

    val viewState: Observable<FoodListViewState> =
        Observable.combineLatest(
            searchQueries,
            foodListObservable,
            progressObservable,
            { query, foodList, progress ->
                FoodListViewState(
                    progress,
                    foodList.filter { satisfiesQuery(it, query) }
                        .map(this::mapItem))
            }
        )

    private val compositeDisposable = CompositeDisposable()
    private val repository: FoodRepository = LocalRepository

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun submitQuery(query: String) = searchQueries.onNext(query)


    fun loadInitialContent() {
        compositeDisposable += repository.getFoodList()
            .doOnSubscribe { progressObservable.onNext(true) }
            .doOnSuccess { progressObservable.onNext(false) }
            .subscribeBy(
                onSuccess = { foodListObservable.onNext(it) },
                onError = { foodListObservable.onError(it) }
            )
    }

    private fun satisfiesQuery(food: FoodItem, query: String): Boolean =
        food.name.toLowerCase(Locale.getDefault()).contains(query)

    private fun mapItem(foodItem: FoodItem): FoodUI {
        return FoodUI(foodItem.name, foodItem.imageData, foodItem.dangerLevel, foodItem.id)
    }
}
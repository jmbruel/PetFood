package com.mexator.petfoodinspector.ui.foodlist

import androidx.lifecycle.ViewModel
import com.mexator.petfoodinspector.data.FoodRepository
import com.mexator.petfoodinspector.data.mock.MockRepository
import com.mexator.petfoodinspector.data.pojo.FoodItem
import com.mexator.petfoodinspector.ui.foodlist.recycler.FoodUI
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.BehaviorSubject

class FoodListViewModel : ViewModel() {
    data class FoodListViewState(
        val displayedItems: List<FoodUI>
    )

    private val _viewState: BehaviorSubject<FoodListViewState> = BehaviorSubject.create()
    val viewState: Observable<FoodListViewState> = _viewState
        .doOnSubscribe {loadInitialContent()}
    private val compositeDisposable = CompositeDisposable()

    private val repository: FoodRepository = MockRepository

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun loadInitialContent() {
        compositeDisposable += repository.getFoodList()
            .subscribeBy(
                onSuccess = {
                    _viewState.onNext(
                        FoodListViewState(it.map(this::mapItem))
                    )
                },
                onError = {
                    _viewState.onError(it)
                }
            )
    }

    private fun mapItem(foodItem: FoodItem): FoodUI {
        return FoodUI(foodItem.name, foodItem.imageUrl, foodItem.dangerLevel, foodItem.id)
    }
}
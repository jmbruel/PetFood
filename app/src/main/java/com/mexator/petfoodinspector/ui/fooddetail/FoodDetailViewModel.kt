package com.mexator.petfoodinspector.ui.fooddetail

import androidx.lifecycle.ViewModel
import com.mexator.petfoodinspector.data.FoodRepository
import com.mexator.petfoodinspector.data.local.LocalRepository
import com.mexator.petfoodinspector.data.mock.MockRepository
import com.mexator.petfoodinspector.data.pojo.FoodDetail
import com.mexator.petfoodinspector.ui.foodlist.FoodListViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

class FoodDetailViewModel : ViewModel() {
    data class FoodDetailViewState(
        val foodDetail: FoodDetail
    )

    private val _viewState: BehaviorSubject<FoodDetailViewState> = BehaviorSubject.create()
    val viewState: Observable<FoodDetailViewState> = _viewState
        .doOnSubscribe { loadInitialContent() }

    private val compositeDisposable = CompositeDisposable()

    private val repository: FoodRepository = LocalRepository

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun loadInitialContent() {
        compositeDisposable += repository.getDetail(foodId)
            .subscribeBy(
                onSuccess = {
                    _viewState.onNext(
                        FoodDetailViewState(it)
                    )
                },
                onError = {
                    _viewState.onError(it)
                }
            )
    }

    var foodId: Int = 0
}
package com.mexator.petfoodinspector.ui.fooddetail

import androidx.lifecycle.ViewModel
import com.mexator.petfoodinspector.data.network.RemoteRepository
import com.mexator.petfoodinspector.domain.FoodRepository
import com.mexator.petfoodinspector.domain.data.FoodDetail
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.BehaviorSubject

class FoodDetailViewModel : ViewModel() {
    data class FoodDetailViewState(
        val foodDetail: FoodDetail
    )

    private val _viewState: BehaviorSubject<FoodDetailViewState> = BehaviorSubject.create()
    val viewState: Observable<FoodDetailViewState> = _viewState
        .doOnSubscribe { loadInitialContent() }

    private val compositeDisposable = CompositeDisposable()

    private val repository: FoodRepository = RemoteRepository

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
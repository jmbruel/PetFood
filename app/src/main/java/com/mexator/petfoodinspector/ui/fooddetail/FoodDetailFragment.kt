package com.mexator.petfoodinspector.ui.fooddetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.mexator.petfoodinspector.databinding.FragmentFoodDetailBinding
import com.mexator.petfoodinspector.ui.foodlist.FoodListPageFragment
import com.mexator.petfoodinspector.ui.foodlist.FoodListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private val viewModel: FoodDetailViewModel by viewModels()
    private var viewModelDisposable: Disposable? = null

    private val foodId: Int by lazy { arguments?.getInt(ARG_FOOD_KEY) ?: 0 }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodDetailBinding.inflate(layoutInflater, container, false)
        viewModel.foodId = foodId
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelDisposable =
            viewModel.viewState
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = this::applyViewState,
                    onError = { throwable -> Log.d(FoodListPageFragment.TAG, "", throwable) }
                )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModelDisposable?.dispose()
    }

    private fun applyViewState(state: FoodDetailViewModel.FoodDetailViewState) {
        binding.foodDetailText.text = state.foodDetail.detailText
        Glide.with(binding.foodPicture).load(state.foodDetail.url).into(binding.foodPicture)
    }

    companion object {
        const val TAG = "FoodDetailFragment"
        const val ARG_FOOD_KEY = "foodId"
    }
}
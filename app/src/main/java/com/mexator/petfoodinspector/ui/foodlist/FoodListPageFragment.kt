package com.mexator.petfoodinspector.ui.foodlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mexator.petfoodinspector.R
import com.mexator.petfoodinspector.databinding.FragmentPageFoodlistBinding
import com.mexator.petfoodinspector.ui.dpToPx
import com.mexator.petfoodinspector.ui.fooddetail.FoodDetailFragment
import com.mexator.petfoodinspector.ui.foodlist.recycler.FoodHolderFactory
import com.mexator.petfoodinspector.ui.foodlist.recycler.FoodUI
import com.mexator.petfoodinspector.ui.recycler.BaseAdapter
import com.mexator.petfoodinspector.ui.recycler.base.ViewTyped
import com.mexator.petfoodinspector.ui.recycler.common.SpaceDecorator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class FoodListPageFragment : Fragment() {
    private lateinit var binding: FragmentPageFoodlistBinding
    private val adapter = BaseAdapter<ViewTyped>(FoodHolderFactory(this::onFoodClicked))
    private val foodListViewModel: FoodListViewModel by viewModels()
    private var viewModelDisposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPageFoodlistBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.foodRecycler.adapter = adapter
        binding.foodRecycler.addItemDecoration(SpaceDecorator(requireContext().dpToPx(8)))
        binding.foodRecycler.layoutManager = LinearLayoutManager(binding.foodRecycler.context)

        viewModelDisposable =
            foodListViewModel.viewState
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = this::applyViewState,
                    onError = { throwable -> Log.d(TAG, "", throwable) }
                )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModelDisposable?.dispose()
    }

    private fun applyViewState(state: FoodListViewModel.FoodListViewState) {
        binding.foodRecycler.visibility = if (state.progress) View.INVISIBLE else View.VISIBLE
        binding.foodProgress.visibility = if (state.progress) View.VISIBLE else View.INVISIBLE
        adapter.items = state.displayedItems
    }

    private fun onFoodClicked(food: FoodUI) {
        val navController = findNavController()
        val args: Bundle = Bundle()
        args.putInt(FoodDetailFragment.ARG_FOOD_KEY, food.uid)
        navController.navigate(R.id.action_foodListPageFragment_to_foodDetailFragment,args)
    }


    companion object {
        const val TAG = "FoodListPageFragment"
    }
}
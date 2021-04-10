package com.mexator.petfoodinspector.ui.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mexator.petfoodinspector.data.DangerLevel
import com.mexator.petfoodinspector.databinding.FragmentPageFoodlistBinding
import com.mexator.petfoodinspector.ui.dpToPx
import com.mexator.petfoodinspector.ui.foodlist.recycler.FoodHolderFactory
import com.mexator.petfoodinspector.ui.foodlist.recycler.FoodUI
import com.mexator.petfoodinspector.ui.recycler.BaseAdapter
import com.mexator.petfoodinspector.ui.recycler.base.ViewTyped
import com.mexator.petfoodinspector.ui.recycler.common.SpaceDecorator

class FoodListPageFragment : Fragment() {
    private lateinit var binding: FragmentPageFoodlistBinding
    private val adapter = BaseAdapter<ViewTyped>(FoodHolderFactory())

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
        val imageUrl = "https://public-media.si-cdn.com/filer/d5/24/d5243019-e0fc-4b3c-8cdb-48e22f38bff2/istock-183380744.jpg"
        adapter.items = listOf(
            FoodUI("Banana", FoodPictureData(imageUrl), DangerLevel.Treat, 2),
            FoodUI("Nuts", FoodPictureData(imageUrl), DangerLevel.Safe, 1),
            FoodUI("Chocolate", FoodPictureData(imageUrl), DangerLevel.Danger, 3),
        )
    }
}
package com.mexator.petfoodinspector.ui.foodlist.recycler

import android.content.res.ColorStateList
import androidx.core.content.res.ResourcesCompat
import com.mexator.petfoodinspector.R
import com.mexator.petfoodinspector.data.DangerLevel
import com.mexator.petfoodinspector.databinding.ItemFoodBinding
import com.mexator.petfoodinspector.ui.getResources
import com.mexator.petfoodinspector.ui.recycler.BaseViewHolder
import com.mexator.petfoodinspector.ui.recycler.base.ViewTyped

data class FoodUI(
    val name: String,
    val dangerLevel: DangerLevel,
    override val uid: Int,
    override val viewType: Int = R.layout.item_food
) : ViewTyped

class FoodViewHolder(private val binding: ItemFoodBinding) : BaseViewHolder<FoodUI>(binding.root) {
    override fun bind(item: FoodUI) {
        binding.foodName.text = item.name
        binding.dangerLevel.text = item.dangerLevel.levelString
        val colorRes = when (item.dangerLevel) {
            DangerLevel.Danger -> R.color.red_500
            DangerLevel.Safe -> R.color.green_500
            DangerLevel.Treat -> R.color.yellow_500
        }
        val color = ResourcesCompat.getColor(binding.getResources(), colorRes, null)
        binding.dangerLevel.backgroundTintList = ColorStateList.valueOf(color)
    }
}
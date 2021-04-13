package com.mexator.petfoodinspector.ui.recycler.common

import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

/**
 * Adds margins to each element. Horizontal margin is twice greater then vertical
 */
class SpaceDecorator(@Px offset: Float) : RecyclerView.ItemDecoration() {
    private val offset = offset.toInt()
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        outRect.apply {
            left = offset
            right = offset
            top = offset / 2
            bottom = offset / 2
        }
    }
}
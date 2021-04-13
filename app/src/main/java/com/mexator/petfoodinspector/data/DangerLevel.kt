package com.mexator.petfoodinspector.data

import androidx.annotation.ColorRes
import com.mexator.petfoodinspector.R

enum class DangerLevel(val levelString: String, @ColorRes val colorRes: Int) {
    Danger("Danger", R.color.red_500),
    Treat("Treat", R.color.yellow_500),
    Safe("Safe", R.color.green_500),
}
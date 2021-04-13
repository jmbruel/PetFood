package com.mexator.petfoodinspector.ui.data

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide

sealed class FoodPicture {
    class LocalFoodPicture(val assetsFile: String) : FoodPicture()
    class RemoteFoodPicture(val link: String) : FoodPicture()
}

class FoodPictureDrawableFactory {
    fun createDrawable(context: Context, pictureData: FoodPicture): Drawable {
        return when (pictureData) {
            is FoodPicture.LocalFoodPicture -> loadPictureFromAssets(
                pictureData.assetsFile,
                context
            )
            is FoodPicture.RemoteFoodPicture -> loadRemotePicture(
                pictureData.link,
                context
            )
        }
    }

    private fun loadPictureFromAssets(path: String, context: Context): Drawable {
        return Drawable.createFromStream(context.assets.open(path), null)
    }

    private fun loadRemotePicture(uri: String, context: Context): Drawable {
        return Glide.with(context).load(uri).submit().get()
    }
}

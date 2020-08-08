package com.example.alodoktermobiletest.homescreen.home.detail

import android.widget.ImageView
import ss.com.bannerslider.ImageLoadingService

class DetailImageLoadingService : ImageLoadingService {
    override fun loadImage(url: String?, imageView: ImageView?) {
        //implement when needed
    }

    override fun loadImage(resource: Int, imageView: ImageView?) {
        imageView?.setImageResource(resource)
    }

    override fun loadImage(
        url: String?,
        placeHolder: Int,
        errorDrawable: Int,
        imageView: ImageView?
    ) {
        //implement when needed
    }

}
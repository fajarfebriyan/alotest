package com.example.alodoktermobiletest.homescreen.home

import androidx.lifecycle.ViewModel
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.data.model.ImageCard

class HomeViewModel : ViewModel() {

    var list: ArrayList<ImageCard> = ArrayList()

    fun fillList() {
        val detailList1 = ImageCard()
        detailList1.imageCover = R.drawable.image1
        detailList1.imageList = arrayListOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )

        val detailList2 = ImageCard()
        detailList2.imageCover = R.drawable.image4
        detailList2.imageList = arrayListOf(
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6
        )

        val detailList3 = ImageCard()
        detailList3.imageCover = R.drawable.image7
        detailList3.imageList = arrayListOf(
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
        )

        list.add(detailList1)
        list.add(detailList2)
        list.add(detailList3)
    }
}
package com.example.alodoktermobiletest.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ImageCard (
    var imageCover: Int? = 0,
    var imageList: ArrayList<Int>? = null
): Parcelable
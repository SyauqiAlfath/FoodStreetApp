package com.example.uts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodClass(
    val foodimg: Int,
    val foodname: String,
    val foodprice: String,
    val fooddesc: String,
    val foodrate: String,
    val ratingbar: Double


) : Parcelable
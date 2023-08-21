package com.example.androidstudycodes.navigation_test

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomObject(
    val name : String,
    val content : String
):Parcelable

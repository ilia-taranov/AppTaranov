package com.example.apptaranov.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor(
        val name: String,
        val imageResourceId: Int
) : Parcelable
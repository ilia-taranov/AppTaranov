package com.example.apptaranov.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
        val title: String,
        val ageLimit: String,
        val isLike: Boolean,
        val rating: Float,
        val annotation: String,
        val description: String,
        val reviewsCount: Int,
        val duration: Int,
        val coverResourceId: Int,
        val actors: List<Actor>
) : Parcelable
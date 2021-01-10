package com.example.apptaranov.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
        val id: Int,
        val title: String,
        val overview: String,
        val poster: String,
        val backdrop: String,
        val ratings: Float,
        val numberOfRatings: Int,
        val minimumAge: Int,
        val runtime: Int,
        val genres: List<Genre>,
        val actors: List<Actor>
): Parcelable {

    fun getGenres(): String {
        var a = ""
        genres.forEach {
            a += it.name + ", "
        }
        return a.trimEnd(',', ' ')
    }
}
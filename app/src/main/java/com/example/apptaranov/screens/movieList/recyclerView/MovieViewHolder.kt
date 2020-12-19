package com.example.apptaranov.screens.movieList.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apptaranov.R
import com.example.apptaranov.data.Movie
import kotlinx.android.synthetic.main.view_holder_movie.view.*


class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie) {
        itemView.movies_list_film_name_text.text = movie.title
        itemView.age_limit_text_view.text = movie.ageLimit
        itemView.rating_bar.rating = movie.rating

        val reviewCount = "${movie.reviewsCount} ${itemView.context.getString(R.string.review_count)}"
        itemView.movie_reviews_count_text.text = reviewCount

        val movieTime = "${movie.duration} ${itemView.context.getString(R.string.min)}"
        itemView.movie_time_text.text = movieTime

        itemView.cover_image_view.setImageResource(movie.coverResourceId)
    }
}
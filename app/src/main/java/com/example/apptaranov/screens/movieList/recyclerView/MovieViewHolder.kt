package com.example.apptaranov.screens.movieList.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apptaranov.R
import com.example.apptaranov.data.Movie
import kotlinx.android.synthetic.main.view_holder_movie.view.*


class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie) {
        itemView.movies_list_film_name_text.text = movie.title
        itemView.age_limit_text_view.text = itemView.context.getString(R.string.minimum_age, movie.minimumAge)
        itemView.movies_list_film_name_text.text = movie.getGenres()
        itemView.rating_bar.rating = movie.ratings
        itemView.movie_reviews_count_text.text = itemView.context.getString(R.string.review_count, movie.numberOfRatings)
        itemView.movie_time_text.text = itemView.context.getString(R.string.min, movie.runtime)

        Glide
            .with(itemView.context)
            .load(movie.poster)
            .into(itemView.cover_image_view)
    }
}
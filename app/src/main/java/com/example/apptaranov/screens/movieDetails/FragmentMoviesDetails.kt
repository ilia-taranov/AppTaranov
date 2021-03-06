package com.example.apptaranov.screens.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.apptaranov.R
import com.example.apptaranov.data.Movie
import com.example.apptaranov.screens.movieDetails.recyclerView.ActorAdapter
import kotlinx.android.synthetic.main.fragment_movies_details.*

class FragmentMoviesDetails : Fragment() {

    private val adapter = ActorAdapter()
    private lateinit var movie: Movie

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie = arguments?.getParcelable<Movie>(MOVIE) as Movie
        configureElements()
        configureRecyclerView()
    }

    private fun configureElements() {
        movie_name_text_view.text = movie.title
        genre_tags_text_view.text = movie.getGenres()
        PG_rating_text_view.text = context?.getString(R.string.minimum_age, movie.minimumAge)
        reviews_text_view.text = context?.getString(R.string.review_count, movie.numberOfRatings)
        movie_description_text_view.text = movie.overview

        Glide
            .with(this)
            .load(movie.backdrop)
            .into(poster_image_view)
    }

    private fun configureRecyclerView() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        actors_recycler_view.layoutManager = layoutManager
        actors_recycler_view.adapter = adapter

        adapter.fill(movie.actors)
    }

    companion object {
        private const val MOVIE = "MOVIE"

        fun newInstance(movie: Movie) = FragmentMoviesDetails().apply {
            arguments = Bundle().apply {
                putParcelable(MOVIE, movie)
            }
        }
    }
}
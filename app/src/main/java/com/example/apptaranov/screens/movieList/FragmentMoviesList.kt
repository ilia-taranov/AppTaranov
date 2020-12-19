package com.example.apptaranov.screens.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptaranov.R
import com.example.apptaranov.data.Actor
import com.example.apptaranov.data.Movie
import com.example.apptaranov.screens.movieDetails.FragmentMoviesDetails
import com.example.apptaranov.screens.movieList.recyclerView.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movies_list.*

class FragmentMoviesList : Fragment() {

    private val adapter = MovieAdapter()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        val gridManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        movies_recycler_view.layoutManager = gridManager
        movies_recycler_view.adapter = adapter

        adapter.fill(getMovieItems())

        adapter.onItemClick = {
            parentFragmentManager.beginTransaction()
                    .apply {
                        add(R.id.container, FragmentMoviesDetails.newInstance(it))
                        addToBackStack(FragmentMoviesDetails::class.java.simpleName)
                        commit()
                    }
        }
    }

    private fun getMovieItems(): List<Movie> {
        return listOf(
                Movie(title = "Avengers: End Game",
                        ageLimit = "14+",
                        isLike = true,
                        rating = 4.0F,
                        annotation = "Action, Adventure, Drama",
                        description = "Description",
                        reviewsCount = 100,
                        duration = 160,
                        coverResourceId = R.drawable.img_movies_cover_avengers,
                        actors = getActorList()),
                Movie(title = "Tenet",
                        ageLimit = "16+",
                        isLike = true,
                        rating = 4.5F,
                        annotation = "Action, Sci-Fi, Thriller",
                        description = "Description",
                        reviewsCount = 98,
                        duration = 999,
                        coverResourceId = R.drawable.img_movies_cover_avengers,
                        actors = getActorList()),
                Movie(title = "Black Widow",
                        ageLimit = "16+",
                        isLike = true,
                        rating = 3F,
                        annotation = "Action, Adventure, Sci-Fi",
                        description = "Description",
                        reviewsCount = 100,
                        duration = 140,
                        coverResourceId = R.drawable.img_movies_cover_avengers,
                        actors = getActorList()),
                Movie(title = "Wonder Woman 1984",
                        ageLimit = "16+",
                        isLike = true,
                        rating = 3F,
                        annotation = "Action, Adventure, Fantasy",
                        description = "Description",
                        reviewsCount = 100,
                        duration = 90,
                        coverResourceId = R.drawable.img_movies_cover_avengers,
                        actors = getActorList())
        )
    }

    private fun getActorList(): List<Actor> {
        return listOf(
                Actor(name = "Robert Downey Jr.",
                        imageResourceId = R.drawable.temp_av1
                ),
                Actor(name = "Chris Evans",
                        imageResourceId = R.drawable.temp_av2
                ),
                Actor(name = "Mark Ruffalo",
                        imageResourceId = R.drawable.temp_av3
                ),
                Actor(name = "Chris Hemsworth",
                        imageResourceId = R.drawable.temp_av4
                ),
                Actor(name = "Bred Pitt",
                        imageResourceId = R.drawable.temp_av1
                )
        )
    }

    companion object {
        fun newInstance() = FragmentMoviesList()
    }
}
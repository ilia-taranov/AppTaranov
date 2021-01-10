package com.example.apptaranov.screens.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptaranov.R
import com.example.apptaranov.data.loadMovies
import com.example.apptaranov.screens.movieDetails.FragmentMoviesDetails
import com.example.apptaranov.screens.movieList.recyclerView.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movies_list.*
import kotlinx.coroutines.*

class FragmentMoviesList : Fragment() {

    private val adapter = MovieAdapter()
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {it ->
            scope.launch {
                val movies = loadMovies(it)
                adapter.fill(movies)
            }
        }

        configureRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private fun configureRecyclerView() {
        val gridManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        movies_recycler_view.layoutManager = gridManager
        movies_recycler_view.adapter = adapter

        adapter.onItemClick = {
            parentFragmentManager.beginTransaction()
                    .apply {
                        add(R.id.container, FragmentMoviesDetails.newInstance(it))
                        addToBackStack(FragmentMoviesDetails::class.java.simpleName)
                        commit()
                    }
        }
    }

    companion object {
        fun newInstance() = FragmentMoviesList()
    }
}
package com.example.apptaranov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_movies_list.*

class FragmentMoviesList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movies_list_item_container.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .apply {
                    add(R.id.container, FragmentMoviesDetails.newInstance())
                    addToBackStack(FragmentMoviesDetails::class.java.simpleName)
                    commit()
                }
        }
    }

    companion object {
        fun newInstance() = FragmentMoviesList()
    }
}
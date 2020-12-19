package com.example.apptaranov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apptaranov.screens.movieList.FragmentMoviesList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentMoviesList.newInstance())
                .addToBackStack(FragmentMoviesList::class.java.simpleName)
                .commit()
        }
    }
}
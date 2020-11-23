package com.example.apptaranov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movie_details_btn.setOnClickListener { showMovieDetails() }
    }

    private fun showMovieDetails() {
        startActivity(Intent(this, MovieDetailsActivity::class.java))
    }
}
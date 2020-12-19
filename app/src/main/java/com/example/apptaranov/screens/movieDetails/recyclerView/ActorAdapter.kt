package com.example.apptaranov.screens.movieDetails.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptaranov.R
import com.example.apptaranov.data.Actor

class ActorAdapter : RecyclerView.Adapter<ActorViewHolder>() {

    private val movies = ArrayList<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        return ActorViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movies.count()
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    // Public Methods

    fun fill(items: List<Actor>) {
        movies.clear()
        movies.addAll(items)
        notifyDataSetChanged()
    }
}
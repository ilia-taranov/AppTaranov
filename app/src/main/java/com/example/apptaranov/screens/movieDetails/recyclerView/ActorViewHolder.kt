package com.example.apptaranov.screens.movieDetails.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apptaranov.data.Actor
import kotlinx.android.synthetic.main.view_holder_actor.view.*

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(actor: Actor) {
        itemView.name_text_view.text = actor.name

        Glide
            .with(itemView.context)
            .load(actor.picture)
            .into(itemView.avatar_image_view)
    }
}
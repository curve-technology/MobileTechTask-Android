package com.curve.techtask.movies.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.curve.techtask.data.repository.Movie
import com.curve.techtask.movies.R
import com.google.android.material.textview.MaterialTextView
import com.nostra13.universalimageloader.core.ImageLoader
import com.squareup.picasso.Picasso

class MovieListAdapter : ListAdapter<Movie, MovieViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val entry = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list_entry, parent, false)
        return MovieViewHolder(entry)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with (getItem(position)) {
            holder.bind(this)
        }
    }
}

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleView = itemView.findViewById<MaterialTextView>(R.id.title)
    private val coverView = itemView.findViewById<ImageView>(R.id.cover)

    fun bind(item: Movie) {
        titleView.text = item.title
        ImageLoader.getInstance().displayImage("https://image.tmdb.org/t/p/original" + item.posterPath, coverView)
    }

}
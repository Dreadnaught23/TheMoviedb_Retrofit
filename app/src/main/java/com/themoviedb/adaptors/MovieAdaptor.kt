package com.themoviedb.adaptors

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.themoviedb.MovieDetailActivity
import com.themoviedb.R
import com.themoviedb.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdaptor(
    private val movies : List<Movie>
): RecyclerView.Adapter<MovieAdaptor.MovieViewHolder>(){
    class MovieViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
        fun bindMovie(movie: Movie){
            itemView.movie_title.text = movie.title
            itemView.movie_overview.text = movie.overview
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindMovie(movies.get(position))
        holder.itemView.setOnClickListener{
            moveToMovieDetail(movie,it)
        }
    }

    private fun moveToMovieDetail(movie: Movie, it: View?) {
        //it itu ditambah !!
        val detailMovieIntent = Intent(it!!.context,MovieDetailActivity::class.java)
        detailMovieIntent.putExtra(MovieDetailActivity.EXTRA_MOVIES,movie)
        it.context.startActivity(detailMovieIntent)
    }
}
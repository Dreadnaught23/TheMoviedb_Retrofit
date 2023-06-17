package com.themoviedb.service

import com.themoviedb.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
interface MovieApiInterface {
    @GET("3/movie/popular?api_key=59cf6f60fc83eb7171057b2a7fdf0d5c")
    fun getMovieList() : Call<MovieResponse>
}
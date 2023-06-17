package com.themoviedb.service

import com.themoviedb.model.TVResponse
import retrofit2.Call
import retrofit2.http.GET


interface TVApiInterface {
    @GET("3/tv/popular?api_key=59cf6f60fc83eb7171057b2a7fdf0d5c")
    fun getTVList() : Call<TVResponse>
}
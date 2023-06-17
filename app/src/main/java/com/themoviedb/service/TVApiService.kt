package com.themoviedb.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface TVApiService {
    companion object val BASE_URL: String
        get() = "https://www.api.themoviedb.org"

    var retrofit : Retrofit?

    fun getInstance(): Retrofit {
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit!!
    }
}
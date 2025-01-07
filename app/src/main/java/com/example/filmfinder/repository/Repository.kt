package com.example.filmfinder.repository

import com.example.filmfinder.retrofit.Movie
import com.example.filmfinder.retrofit.RetrofitInstance

class Repository {

    suspend fun getPopularMoviesFromApi(apiKey: String): List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
}
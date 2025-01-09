package com.example.filmfinder.repository

import android.content.Context
import com.example.filmfinder.retrofit.Movie
import com.example.filmfinder.retrofit.RetrofitInstance
import com.example.filmfinder.room.MoviesDataBase

class Repository(context: Context) {

    private var db = MoviesDataBase.getInstance(context)
    private var movieDAO = db.dao

    suspend fun getPopularMoviesFromApi(apiKey: String): List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        return movieDAO.getAllMoviesFromDB()
    }

    suspend fun clearDB(){
        movieDAO.clearDB()
    }

    suspend fun insertMoviesIntoDB(movies: List<Movie>){
        movieDAO.insertMoviesList(movies)
    }

}
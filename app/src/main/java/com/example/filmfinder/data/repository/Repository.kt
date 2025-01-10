package com.example.filmfinder.data.repository

import android.content.Context
import com.example.filmfinder.data.model.Movie
import com.example.filmfinder.data.retrofit.RetrofitInstance
import com.example.filmfinder.data.room.MoviesDataBase

class Repository(context: Context) {

    private var db = MoviesDataBase.getInstance(context)
    private var dao = db.dao

    suspend fun getPopularMoviesFromApi(apiKey: String): List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        return dao.getAllMoviesFromDB()
    }

    suspend fun getMovieFromApiByID(id: Int, apiKey: String): Movie{
        return RetrofitInstance.api.getMovieByID(id, apiKey)
    }

    suspend fun getMovieFromDBByID(id: Int): Movie{
        return dao.getMovieByID(id)
    }


    suspend fun clearDB(){
        dao.clearDB()
    }

    suspend fun insertMoviesIntoDB(movies: List<Movie>){
        dao.insertMoviesList(movies)
    }

}
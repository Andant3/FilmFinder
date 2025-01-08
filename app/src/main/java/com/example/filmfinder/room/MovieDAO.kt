package com.example.filmfinder.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.filmfinder.retrofit.Movie

@Dao
interface MovieDAO {

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesList(movies: List<Movie>)

    @androidx.room.Query("SELECT * FROM movies_table")
    suspend fun getAllMoviesFromDB(): List<Movie>
}
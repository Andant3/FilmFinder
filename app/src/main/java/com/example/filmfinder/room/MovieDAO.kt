package com.example.filmfinder.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.filmfinder.model.Movie

@Dao
interface MovieDAO {

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("DELETE FROM movies_table")
    suspend fun clearDB()

    @Query("SELECT * FROM movies_table ORDER BY popularity DESC")
    suspend fun getAllMoviesFromDB(): List<Movie>
}
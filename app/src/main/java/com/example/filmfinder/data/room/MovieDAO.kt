package com.example.filmfinder.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.filmfinder.data.model.Movie

@Dao
interface MovieDAO {

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM movies_table WHERE id = :id")
    suspend fun getMovieByID(id: Int): Movie

    @Query("DELETE FROM movies_table")
    suspend fun clearDB()

    @Query("SELECT * FROM movies_table ORDER BY popularity DESC")
    suspend fun getAllMoviesFromDB(): List<Movie>
}
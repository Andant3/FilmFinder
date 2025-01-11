package com.example.filmfinder.ui.viewmodel_movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmfinder.data.model.Movie
import com.example.filmfinder.data.repository.Repository
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: Repository) : ViewModel() {


    var movie by mutableStateOf(Movie.UNDEFINED_MOVIE)
        private set
    var movieFromApi by mutableStateOf(Movie.UNDEFINED_MOVIE)
        private set
    var movieFromDB by mutableStateOf(Movie.UNDEFINED_MOVIE)
        private set

    fun getMovieById(id: Int): Movie {
        viewModelScope.launch {
            try {
                movieFromApi = repository.getMovieFromApiByID(
                    id,
                    "0a4f5f7d3524e846f975929cbf419d43"
                )
                movie = movieFromApi
            } catch (e: Exception) {
                movieFromDB = repository.getMovieFromDBByID(id)
                movie = movieFromDB
            }
        }
        return movie
    }
}
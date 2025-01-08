package com.example.filmfinder.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmfinder.repository.Repository
import com.example.filmfinder.retrofit.Movie
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromDB by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {
                moviesFromApi = repository.getPopularMoviesFromApi("0a4f5f7d3524e846f975929cbf419d43")

                repository.insertMoviesIntoDB(moviesFromApi)

                movies = moviesFromApi
            } catch (e: Exception) {
                moviesFromDB = repository.getMoviesFromDB()
                movies = moviesFromDB
            }
        }
    }
}
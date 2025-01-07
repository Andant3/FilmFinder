package com.example.filmfinder.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmfinder.repository.Repository
import com.example.filmfinder.retrofit.Movie
import kotlinx.coroutines.launch

class MoviesViewModel(repository: Repository) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {
                moviesFromApi = repository.getPopularMoviesFromApi("0a4f5f7d3524e846f975929cbf419d43")
                movies = moviesFromApi
            } catch (e: Exception) {
                TODO("Fetch the data from ROOM DB")
            }
        }
    }
}
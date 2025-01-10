package com.example.filmfinder.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmfinder.data.repository.Repository
import com.example.filmfinder.data.model.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(repository: Repository) : ViewModel() {

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

                repository.clearDB()
                repository.insertMoviesIntoDB(moviesFromApi)

                movies = moviesFromApi
                Log.i("TAGY", "Movies Loaded From Api")
            } catch (e: Exception) {
                moviesFromDB = repository.getMoviesFromDB()
                movies = moviesFromDB
                Log.i("TAGY", "Movies Loaded From DB")
            }
        }
    }
}
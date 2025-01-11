package com.example.filmfinder.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmfinder.data.model.Movie
import com.example.filmfinder.data.repository.Repository
import kotlinx.coroutines.launch

class MovieListViewModel(private val repository: Repository) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    private var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())

    private var moviesFromDB by mutableStateOf<List<Movie>>(emptyList())

    private var currentPage by mutableIntStateOf(0)


    fun onEvent(event: MovieListViewModelEvent) {
        when (event) {
            MovieListViewModelEvent.LoadNextPage -> {
                addMoviesFromNextPage()
            }
        }
    }

    private fun addMoviesFromNextPage() {
        viewModelScope.launch {
            try {
                moviesFromApi += repository.getPopularMoviesFromApi(
                    ++currentPage,
                    "0a4f5f7d3524e846f975929cbf419d43"
                )

                repository.clearDB()
                repository.insertMoviesIntoDB(moviesFromApi)

                movies = moviesFromApi

                Log.i("TAGY", "Movies Loaded From Api")
            } catch (e: Exception) {
                moviesFromDB = repository.getMoviesFromDB()
                movies = moviesFromDB
                Log.i("TAGY", "Movies Loaded From DB // ${e.message}")
            }
        }
    }


    init {
        addMoviesFromNextPage()
    }
}
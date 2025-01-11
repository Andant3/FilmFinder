package com.example.filmfinder.ui.viewmodel_list

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

    val currentOrder = mutableStateOf(OrderType())




    fun onEvent(event: MovieListViewModelEvent) {
        when (event) {
            MovieListViewModelEvent.LoadNextPage -> {
                addMoviesFromNextPage()
            }

            is MovieListViewModelEvent.Order -> {
                sortMovies(event.movieOrder)
            }
        }
    }

    private fun addMoviesFromNextPage() {

        lateinit var movieOrderApi: String

        when (currentOrder.value.order) {
            is MovieOrder.Popularity -> {
                movieOrderApi = "popularity.desc"
                currentOrder.value.order = MovieOrder.Popularity
            }

            is MovieOrder.Rating -> {
                movieOrderApi = "vote_average.desc"
                currentOrder.value.order = MovieOrder.Rating
            }
        }
        viewModelScope.launch {
            try {
                moviesFromApi += repository.getMoviesFromApi(
                    ++currentPage,
                    movieOrderApi,
                    "0a4f5f7d3524e846f975929cbf419d43"
                )

                //repository.clearDB()
                repository.insertMoviesIntoDB(moviesFromApi)

                movies = moviesFromApi

                Log.i("TAGY", "Movies Loaded From Api")
            } catch (e: Exception) {

                moviesFromDB = repository.getMoviesFromDB(currentOrder.value.order)
                movies = moviesFromDB
                Log.i("TAGY", "Movies Loaded From DB // ${e.message}")
            }
        }
    }

    private fun sortMovies(movieOrder: MovieOrder) {
        lateinit var movieOrderApi: String

        when (movieOrder) {
            is MovieOrder.Popularity -> {
                movieOrderApi = "popularity.desc"
                currentOrder.value.order = MovieOrder.Popularity
            }

            is MovieOrder.Rating -> {
                movieOrderApi = "vote_average.desc"
                currentOrder.value.order = MovieOrder.Rating
            }
        }
        viewModelScope.launch {
            try {
                moviesFromApi = repository.getMoviesFromApi(
                    1,
                    movieOrderApi,
                    "0a4f5f7d3524e846f975929cbf419d43"
                )

                //repository.clearDB()
                repository.insertMoviesIntoDB(moviesFromApi)

                movies = moviesFromApi
                Log.i("TAGY", "Sorted Movies Loaded From Api")
            } catch (e: Exception) {
                moviesFromDB = repository.getMoviesFromDB(movieOrder)
                movies = moviesFromDB
                Log.i("TAGY", "Sorted Movies Loaded From DB // ${e.message}")
            }
        }
    }


    init {
        addMoviesFromNextPage()
    }
}


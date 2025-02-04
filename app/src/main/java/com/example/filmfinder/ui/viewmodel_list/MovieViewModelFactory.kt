package com.example.filmfinder.ui.viewmodel_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmfinder.data.repository.Repository
import com.example.filmfinder.ui.viewmodel_movie.MovieViewModel


class MovieViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        when{
            modelClass.isAssignableFrom(MovieListViewModel::class.java)->{
                return MovieListViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MovieViewModel::class.java)->{
                return MovieViewModel(repository) as T
            }
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
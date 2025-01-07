package com.example.filmfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmfinder.repository.Repository


class MovieViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(ViewModel::class.java)){
            return MovieViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.example.filmfinder.ui.viewmodel

sealed class MovieListViewModelEvent {
    object LoadNextPage: MovieListViewModelEvent()
}
package com.example.filmfinder.ui.viewmodel_list

sealed class MovieListViewModelEvent {
    object LoadNextPage: MovieListViewModelEvent()
    data class Order(val movieOrder: MovieOrder): MovieListViewModelEvent()
}
package com.example.filmfinder.ui.viewmodel_list

sealed class MovieOrder {
    object Rating : MovieOrder()
    object Popularity : MovieOrder()
}
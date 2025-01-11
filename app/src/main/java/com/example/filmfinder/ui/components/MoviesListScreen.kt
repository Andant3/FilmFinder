package com.example.filmfinder.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.filmfinder.ui.viewmodel.MovieListViewModel

@Composable
fun MoviesListScreen(viewModel: MovieListViewModel, navController: NavController) {

    val moviesList = viewModel.movies
    MovieList(
        movies = moviesList,
        viewModel,
        navController
    )
}
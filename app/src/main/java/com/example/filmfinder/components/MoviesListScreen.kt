package com.example.filmfinder.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.filmfinder.viewmodel.MovieViewModel

@Composable
fun MoviesListScreen(viewModel: MovieViewModel, navController: NavController){

    val moviesList = viewModel.movies
    MovieList(movies = moviesList, navController)
}
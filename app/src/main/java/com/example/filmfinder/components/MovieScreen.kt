package com.example.filmfinder.components

import androidx.compose.runtime.Composable
import com.example.filmfinder.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel){

    val moviesList = viewModel.movies
    MovieList(movies = moviesList)
}
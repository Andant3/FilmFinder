package com.example.filmfinder.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.filmfinder.navigation.MovieScreenRoute
import com.example.filmfinder.data.model.Movie

@Composable
fun MovieList(movies: List<Movie>, navController: NavController) {

    LazyColumn {
        items(movies) { movie ->
            MovieItem(
                movie,
                onClick = { navController.navigate(MovieScreenRoute(movie.id)) }
            )
        }
    }
}
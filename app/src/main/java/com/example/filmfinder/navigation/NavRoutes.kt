package com.example.filmfinder.navigation

import kotlinx.serialization.Serializable

@Serializable
object MovieListScreenRoute

@Serializable
data class MovieScreenRoute(
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String
)

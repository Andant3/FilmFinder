package com.example.filmfinder.navigation

import kotlinx.serialization.Serializable

@Serializable
object MovieListScreenRoute

@Serializable
data class MovieScreenRoute(
    val id: Int
)

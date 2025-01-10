package com.example.filmfinder.data.retrofit

import com.example.filmfinder.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    val pages: Int,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

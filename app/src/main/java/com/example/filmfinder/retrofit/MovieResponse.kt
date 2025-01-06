package com.example.filmfinder.retrofit

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val pages: Int,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

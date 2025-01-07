package com.example.filmfinder.retrofit

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Movie(
    @SerializedName("adult")
    val adultRating: Boolean,
    @SerializedName("backdrop_path")
    val backDropPath: String,
    @SerializedName("genre_ids")
    val genreIDs: List<Int>,
    val title: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: Date,
    @SerializedName("vote_average")
    val rating: Double
)

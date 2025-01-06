package com.example.filmfinder.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceTMDB {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String
    ): MovieResponse
}
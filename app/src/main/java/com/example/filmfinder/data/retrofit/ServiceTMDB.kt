package com.example.filmfinder.data.retrofit

import com.example.filmfinder.data.model.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceTMDB {

    @GET("discover/movie")
    suspend fun getSortedMoviesFromPage(
        @Query("page")
        page: Int,
        @Query("sort_by")
        sortBy: String,
        @Query("vote_count.gte")
        voteCount: Int = 100,
        @Query("api_key")
        apiKey: String
    ): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieByID(
        @Path("movie_id")
        id: Int,
        @Query("api_key")
        apiKey: String
    ): Movie
}
package com.example.filmfinder.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("movies_table")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path")
    @ColumnInfo("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    @ColumnInfo("backdrop_path")
    val backdropPath: String,
    @SerializedName("vote_average")
    val rating: Double,
    val popularity: Double,
    @SerializedName("release_date")
    @ColumnInfo("release_date")
    val releaseDate: String
){
    companion object{
        private const val UNDEFINED_ID: Int = -1
        private const val UNDEFINED_TITLE: String = ""
        private const val UNDEFINED_OVERVIEW: String = ""
        private const val UNDEFINED_POSTER_PATH: String = ""
        private const val UNDEFINED_BACKDROP_PATH: String = ""
        private const val UNDEFINED_RATING: Double = 0.0
        private const val UNDEFINED_POPULARITY: Double = 0.0
        private const val UNDEFINED_RELEASE_DATE: String = ""

        val UNDEFINED_MOVIE = Movie(
            UNDEFINED_ID,
            UNDEFINED_TITLE,
            UNDEFINED_OVERVIEW,
            UNDEFINED_POSTER_PATH,
            UNDEFINED_BACKDROP_PATH,
            UNDEFINED_RATING,
            UNDEFINED_POPULARITY,
            UNDEFINED_RELEASE_DATE
        )
    }
}

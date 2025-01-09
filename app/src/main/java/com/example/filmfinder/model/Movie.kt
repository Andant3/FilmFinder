package com.example.filmfinder.model

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
)

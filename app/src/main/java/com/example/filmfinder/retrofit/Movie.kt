package com.example.filmfinder.retrofit

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
    @SerializedName("vote_average")
    val rating: Double? = UNDEFINED
){
    companion object{
        const val UNDEFINED = -1.0
    }
}

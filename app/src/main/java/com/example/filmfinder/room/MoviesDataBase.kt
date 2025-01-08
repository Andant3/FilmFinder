package com.example.filmfinder.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmfinder.retrofit.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDataBase: RoomDatabase() {

    abstract val dao : MovieDAO

    companion object{

        @Volatile
        private var INSTANCE: MoviesDataBase?= null

        fun getInstance(context: Context): MoviesDataBase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDataBase::class.java,
                        "movies_db"
                    ).build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}
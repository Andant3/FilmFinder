package com.example.filmfinder.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.filmfinder.model.Movie

@Database(
    entities = [Movie::class],
    version = 2
)
abstract class MoviesDataBase : RoomDatabase() {

    abstract val dao: MovieDAO

    companion object {

        @Volatile
        private var INSTANCE: MoviesDataBase? = null
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE movies_table ADD COLUMN backdrop_path TEXT NOT NULL DEFAULT ' '")
                database.execSQL("ALTER TABLE movies_table ADD COLUMN release_date TEXT NOT NULL DEFAULT ' '")
            }
        }

        fun getInstance(context: Context): MoviesDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDataBase::class.java,
                        "movies_db"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}
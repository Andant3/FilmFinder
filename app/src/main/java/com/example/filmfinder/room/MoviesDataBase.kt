package com.example.filmfinder.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.filmfinder.retrofit.Movie

@Database(
    entities = [Movie::class],
    version = 3
)
abstract class MoviesDataBase : RoomDatabase() {

    abstract val dao: MovieDAO

    companion object {

        @Volatile
        private var INSTANCE: MoviesDataBase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE movies_table ADD COLUMN rating REAL")
            }
        }
        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE movies_table RENAME COLUMN posterPath TO poster_path")
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
                        .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                        .build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}
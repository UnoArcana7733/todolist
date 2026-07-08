package com.example.todyapp.room

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ThemeColor::class, Schedule::class], version = 1)
@OptIn(ExperimentalMaterial3Api::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun colorDao(): ColorDAO
    abstract fun scheduleDao(): ScheduleDAO
    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase
                = instance ?: synchronized(this) {
            Room.databaseBuilder(context,
                AppDatabase::class.java, "my-db")
                .fallbackToDestructiveMigration(false)
                .build()
                .also { instance = it }
        }
    }
}
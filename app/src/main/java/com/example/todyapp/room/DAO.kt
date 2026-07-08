package com.example.todyapp.room

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
@OptIn(ExperimentalMaterial3Api::class)
interface ColorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun screenSelectColor(vararg themeColor: ThemeColor)
    @Query("SELECT * FROM themeColor")
    suspend fun getAll(): List<ThemeColor>
}

@Dao
@OptIn(ExperimentalMaterial3Api::class)
interface ScheduleDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg schedule: Schedule)
    @Query("SELECT * FROM schedule")
    suspend fun getAll(): List<Schedule>
    @Delete
    fun killingTime(vararg schedule: Schedule)
}
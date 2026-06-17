package com.example.todyapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ColorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun screenSelectColor(vararg themeColor: ThemeColor)
    @Query("SELECT * FROM themeColor")
    suspend fun getAll(): List<ThemeColor>
}

@Dao
interface ScheduleDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg schedule: Schedule)
    @Query("SELECT * FROM schedule")
    suspend fun getAll(): List<Schedule>
}
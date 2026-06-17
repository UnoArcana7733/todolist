package com.example.todyapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themeColor")
data class ThemeColor(@PrimaryKey val id: Int, val selectedColor: String)
@Entity(tableName = "schedule")
data class Schedule(@PrimaryKey(autoGenerate = true) val id: Int = 1, val name: String, val description: String, val date: String, val time: String)
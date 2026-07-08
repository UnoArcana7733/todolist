package com.example.todyapp.room

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themeColor")
data class ThemeColor(@PrimaryKey val id: Int, val selectedColor: String)
@Entity(tableName = "schedule")
@OptIn(ExperimentalMaterial3Api::class)
data class Schedule(@PrimaryKey(autoGenerate = true) val id: Int = 1, val name: String, val description: String, val date: String, val time: String)
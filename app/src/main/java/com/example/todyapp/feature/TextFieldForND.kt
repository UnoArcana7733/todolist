package com.example.todyapp.feature

import android.R.attr.label
import android.app.Dialog
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.todyapp.room.ScheduleDAO

@Composable
fun TFFND(scheduleDao: ScheduleDAO) {
    var scheduleName by remember { mutableStateOf("") }
    var scheduleDescription by remember { mutableStateOf("") }
}
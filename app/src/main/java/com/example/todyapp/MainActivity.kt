package com.example.todyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.todyapp.room.AppDatabase
import com.example.todyapp.room.Schedule
import com.example.todyapp.root.AppNavGraph
import com.example.todyapp.ui.theme.Greenx
import com.example.todyapp.ui.theme.TodyappTheme
import com.example.todyapp.ui.theme.toThemeColor
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodyappTheme {
                val navController = rememberNavController()
                val db = remember{Room.databaseBuilder(applicationContext, AppDatabase::class.java, "AppDatabase").build()}
                val colorDao = remember{db.colorDao()}
                val scheduleDao = remember{db.scheduleDao()}
                var mainColor: Color by remember { mutableStateOf(Greenx) }
                val scope = rememberCoroutineScope()
                val refresh: () -> Unit = {
                    scope.launch {
                        mainColor = colorDao.getAll().firstOrNull()?.selectedColor?.toThemeColor() ?: Greenx
                    }
                }
                LaunchedEffect(Unit) { scope.launch {
                    refresh()
                } }
                AppNavGraph(navController, mainColor, colorDao, scheduleDao, refresh)
            }
        }
    }
}
package com.example.todyapp.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todyapp.room.ColorDAO
import com.example.todyapp.room.ScheduleDAO
import com.example.todyapp.feature.FifthScreen
import com.example.todyapp.feature.FirstScreen
import com.example.todyapp.feature.FourthScreen
import com.example.todyapp.feature.GuideScreen
import com.example.todyapp.feature.SecondScreen
import com.example.todyapp.feature.StartScreen
import com.example.todyapp.feature.ThirdScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    mainColor: Color,
    colorDAO: ColorDAO,
    scheduleDao: ScheduleDAO,
    refresh: ()->Unit
) { NavHost(
        navController = navController,
        startDestination = Start
    ) {
        composable<Start> {
            StartScreen(navController = navController, mainColor = mainColor)
        }
        composable<Guide> {
            GuideScreen(navController = navController, mainColor = mainColor, colorDAO = colorDAO, refresh = refresh)
        }
        composable<First> {
            FirstScreen(navController = navController, mainColor = mainColor, colorDao = colorDAO, scheduleDao=scheduleDao)
        }
        composable<Second> {
            SecondScreen(navController = navController)
        }
        composable<Third> {
            ThirdScreen(navController = navController)
        }
        composable<Fourth> {
            FourthScreen(navController = navController)
        }
        composable<Fifth> {
            FifthScreen(navController = navController)
        }
    }
}

@Serializable
object Start

@Serializable
object Guide

@Serializable
object First

@Serializable
object Second

@Serializable
object Third

@Serializable
object Fourth

@Serializable
object Fifth
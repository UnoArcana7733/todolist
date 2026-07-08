package com.example.todyapp.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.todyapp.ui.components.BottomBar
import com.example.todyapp.ui.components.ScheduleCard
import com.example.todyapp.ui.components.ScheduleCardPU
import com.example.todyapp.ui.components.TopBar
import com.example.todyapp.room.ColorDAO
import com.example.todyapp.room.Schedule
import com.example.todyapp.room.ScheduleDAO
import com.example.todyapp.ui.theme.bgc
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController, mainColor: Color, colorDao: ColorDAO, scheduleDao: ScheduleDAO) {
    Scaffold(topBar = {TopBar(navController)}, bottomBar = {BottomBar(navController)}, modifier = Modifier.background(color=bgc)
    ) {innerPadding ->
        val scope = rememberCoroutineScope()
        var todolist: List<Schedule> by remember { mutableStateOf(emptyList()) }
        LaunchedEffect(scheduleDao) { todolist = scheduleDao.getAll() }
        val refreshSC: () -> Unit = {
            scope.launch {
                todolist=scheduleDao.getAll()
            }
        }
        Column(modifier = Modifier.padding(innerPadding).verticalScroll(rememberScrollState())) {
            ScheduleCardPU(mainColor, colorDao, scheduleDao, refreshSC)
            for(i in todolist){
                println(i) //체크용
                ScheduleCard(mainColor, colorDao, scheduleDao, i)
            }
        }
    }
}
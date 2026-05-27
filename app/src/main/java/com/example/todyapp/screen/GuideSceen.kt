package com.example.todyapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todyapp.feature.BottomText
import com.example.todyapp.feature.CustomGuide
import com.example.todyapp.feature.TopText
import com.example.todyapp.room.ColorDAO
import com.example.todyapp.ui.theme.Black
import com.example.todyapp.ui.theme.Blue
import com.example.todyapp.ui.theme.Greenx
import com.example.todyapp.ui.theme.Greenx
import com.example.todyapp.ui.theme.Red
import com.example.todyapp.ui.theme.bgc

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideScreen(navController: NavController, mainColor: Color, colorDAO: ColorDAO, refresh: ()->Unit) {
    Scaffold(topBar = { TopText() }, bottomBar = { BottomText(navController, mainColor) }
        ) { innerPadding->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = bgc),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.size(20.dp))
                CustomGuide(Greenx, mainColor, colorDAO, refresh)
                Spacer(modifier = Modifier.size(10.dp))
                CustomGuide(Black, mainColor, colorDAO, refresh)
                Spacer(modifier = Modifier.size(10.dp))
                CustomGuide(Blue, mainColor, colorDAO, refresh)
                Spacer(modifier = Modifier.size(10.dp))
                CustomGuide(Red, mainColor, colorDAO, refresh)
                Spacer(modifier = Modifier.size(200.dp))
            }
        }
    }
}

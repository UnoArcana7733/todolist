package com.example.todyapp.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.todyapp.ui.components.BottomBar
import com.example.todyapp.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourthScreen(navController: NavController){
    Scaffold(topBar = {TopBar(navController)}, bottomBar = {BottomBar(navController)}
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
        }
    }
}
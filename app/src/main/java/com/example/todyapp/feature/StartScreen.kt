package com.example.todyapp.feature

//import com.example.todyapp.room.AppDatabase
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todyapp.R
import com.example.todyapp.root.First
import com.example.todyapp.root.Guide
import com.example.todyapp.ui.theme.Greeny
import com.example.todyapp.ui.theme.White
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(navController: NavController, mainColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = mainColor),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_checklist),
                contentDescription = "Checking a list is same with Listing a check.",
                modifier = Modifier.size(100.dp),
            )
            Box(modifier = Modifier.padding(2.dp)){}
            Text(
                text = "TODYAPP",
                fontWeight = Bold,
                fontSize = 26.sp,
                color = White
            )
            Box(modifier = Modifier.padding(1.dp)){}
            Text(
                text = "The best to do list application for you",
                color = White
            )
        }
    }
    LaunchedEffect(Unit)
    {
        delay(300)
        if (mainColor == Greeny) {
            navController.navigate(First)
        }
        else {
            navController.navigate(Guide)
        }
    }
}


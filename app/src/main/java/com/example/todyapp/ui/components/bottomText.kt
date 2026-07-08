package com.example.todyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todyapp.root.First
import com.example.todyapp.ui.theme.bgc

@Composable
fun BottomText(navController: NavController, mainColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().background(color=bgc)) {
        Button(
            onClick = { navController.navigate(First) },
            modifier = Modifier.size(300.dp, 50.dp),
            colors = buttonColors(
                contentColor = bgc,
                containerColor = mainColor
            )
        ) {
            Text(
                text = "Open Todolist",
                fontSize = 20.sp
            )
        }
        Spacer(modifier=Modifier.size(16.dp))
    }
}
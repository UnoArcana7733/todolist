package com.example.todyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todyapp.ui.theme.Black
import com.example.todyapp.ui.theme.bgc

@Composable
fun TopText() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().background(color=bgc)) {
        Spacer(modifier=Modifier.size(60.dp))
        Text(
            text = "Create to do list",
            color = Black,
            fontSize = 24.sp,
            fontWeight = Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Choose your to do list color theme:",
            color = Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}
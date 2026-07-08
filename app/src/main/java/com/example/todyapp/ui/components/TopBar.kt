package com.example.todyapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todyapp.R
import com.example.todyapp.root.Guide
import com.example.todyapp.ui.theme.Black

@Composable
fun TopBar(navController: NavController) {
    Box(modifier = Modifier.fillMaxWidth().size(130.dp), contentAlignment = Alignment.TopCenter) {
        Column {
            Spacer(modifier = Modifier.size(60.dp))
            Row {
                Column {
                    Text(
                        text = "Today",
                        color = Black,
                        fontSize = 25.sp,
                        fontWeight = Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Best Flatform for creating to-do list",
                        color = Black,
                        fontSize = 15.sp,
                        fontWeight = Bold
                    )
                }
                Spacer(modifier=Modifier.size(70.dp))
                Image(
                    painter = painterResource(id = R.drawable.settings_b_roll),
                    contentDescription = "I don't sure we can call this a roll",
                    modifier = Modifier.size(40.dp).clickable {navController.navigate(Guide)},
                    alignment = Alignment.Center
                )
            }
        }
    }
}
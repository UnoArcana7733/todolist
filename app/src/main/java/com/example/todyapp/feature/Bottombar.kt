package com.example.todyapp.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todyapp.R
import com.example.todyapp.root.Fifth
import com.example.todyapp.root.First
import com.example.todyapp.root.Fourth
import com.example.todyapp.root.Guide
import com.example.todyapp.root.Second
import com.example.todyapp.root.Third
import com.example.todyapp.ui.theme.White

@Composable
fun BottomBar(navController: NavController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
                .background(color = White)
                .shadow(1.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home Sweet Home",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable() { navController.navigate(First) },
                    alignment = Alignment.Center,
                )
            }
            Spacer(modifier = Modifier.size(50.dp))
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.move_to_inbox),
                    contentDescription = "Store Araya in the time box",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable() { navController.navigate(Second) },
                    alignment = Alignment.Center
                )
            }
            Spacer(modifier = Modifier.size(50.dp))
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.calendar_month),
                    contentDescription = "July is coming",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable() { navController.navigate(Third) },
                    alignment = Alignment.Center
                )
            }
            Spacer(modifier = Modifier.size(50.dp))
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.window),
                    contentDescription = "Better than mac",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable() { navController.navigate(Fourth) },
                    alignment = Alignment.Center
                )
            }
            Spacer(modifier = Modifier.size(50.dp))
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.add_photo_alternate),
                    contentDescription = "Broken Gallery",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable() { navController.navigate(Fifth) },
                    alignment = Alignment.Center
                )
            }
        }
        Box(modifier= Modifier.size(20.dp).background(White)) //하단에 있으니까 안보여서 넣었습니다
    }
}
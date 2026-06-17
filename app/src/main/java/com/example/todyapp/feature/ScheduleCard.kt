package com.example.todyapp.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todyapp.room.ColorDAO
import com.example.todyapp.room.Schedule
import com.example.todyapp.room.ScheduleDAO
import com.example.todyapp.ui.theme.Gray
import com.example.todyapp.ui.theme.White

@Composable
fun ScheduleCard(
    customColor: Color,
    colorDao: ColorDAO,
    scheduleDao: ScheduleDAO,
    todos: Schedule
) {
    val id = todos.id
    val name = todos.name
    val ds = todos.description
    val date = todos.date
    val time = todos.time
    Box(
        modifier = Modifier
            .size(500.dp, 200.dp)
            .padding(16.dp)
            .shadow(2.dp, RoundedCornerShape(16.dp))
            .background(color = White)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .background(customColor)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(customColor)
                        .clickable() {
                            // 스케줄 제거 기능 구현 예정
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "-",
                        color = White,
                        fontWeight = Bold,
                        fontSize = 25.sp
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column() {Text(text=name);Text(text=ds)}
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(1.dp)
                    .background(customColor)
            )
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {Text(text=date, color = Gray, fontSize = 15.sp);Spacer(modifier = Modifier.weight(1f));Text(text=time, color = Gray, fontSize = 15.sp)}
            }
        }
    }
}
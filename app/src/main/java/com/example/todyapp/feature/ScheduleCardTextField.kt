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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.launch

// Greenx 문제 해결이 늦어져서 급한대로 TF 활용해 DB 사용만 구현했습니다
@Composable
fun ScheduleCardTF(
    customColor: Color,
    colorDao: ColorDAO,
    scheduleDao: ScheduleDAO,
    refreshSC: ()->Unit
) {
    val scope = rememberCoroutineScope()
    var scheduleName by remember { mutableStateOf("") }
    var scheduleDescription by remember { mutableStateOf("") }
    var scheduleDate by remember { mutableStateOf("") }
    var scheduleTime by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .size(500.dp, 420.dp)
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
                            scope.launch {
                                scheduleDao.insert(
//                                    Schedule(
//                                        id = 0,
//                                        name = scheduleName,
//                                        description = scheduleDescription,
//                                        date = scheduleDate,
//                                        time = scheduleTime
//                                    )
                                )
                                println(scheduleDao.getAll()) //DB 작동 테스트용
                                refreshSC()
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "+",
                        color = White,
                        fontWeight = Bold,
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column() {
                    OutlinedTextField(
                        value = scheduleName,
                        onValueChange = { scheduleName = it },
                        label = { Text("작업 이름") }
                    )
                    OutlinedTextField(
                        value = scheduleDescription,
                        onValueChange = { scheduleDescription = it },
                        label = { Text("작업 해설") }
                    )
                }
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
                ) {
                    Text(text = "Add your task", color = Gray, fontSize = 15.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Today . Mon 20 Jul 2022", color = Gray, fontSize = 15.sp)
                }
                Column(modifier = Modifier.padding(start=10.dp,bottom=10.dp)) {
                    OutlinedTextField(
                        value = scheduleDate,
                        onValueChange = { scheduleDate = it },
                        label = { Text("날짜") }
                    )
                    OutlinedTextField(
                        value = scheduleTime,
                        onValueChange = { scheduleTime = it },
                        label = { Text("시간") }
                    )
                }
            }
        }
    }
}
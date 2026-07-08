package com.example.todyapp.ui.components

import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults.dateFormatter
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.todyapp.R
import com.example.todyapp.room.ColorDAO
import com.example.todyapp.room.Schedule
import com.example.todyapp.room.ScheduleDAO
import com.example.todyapp.ui.theme.Black
import com.example.todyapp.ui.theme.Gray
import com.example.todyapp.ui.theme.Milk
import com.example.todyapp.ui.theme.White
import com.example.todyapp.ui.theme.bgc
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Locale

//날짜가 1782518... 같은 식으로 나오는데 고치는 방법을 모르겠어서 ai 사용했습니다
fun formatSelectedDate(millis: Long?): String {
    val formatter = DateTimeFormatter.ofPattern("EEE dd MMM yyyy", Locale.ENGLISH);
    //null값 처리는 제가 했습니다
    if (millis == null){
        return "날짜가 선택되지 않았습니다."
    }
    return Instant.ofEpochMilli(millis)
        .atZone(ZoneOffset.UTC)
        .toLocalDate()
        .format(formatter)
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ScheduleCardPU(
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
    var showTF by remember{mutableStateOf(false)}
    var showDS by remember{mutableStateOf(false)}
    var showTS by remember{mutableStateOf(false)}
    if (showTF) {
        Dialog(onDismissRequest = { showTF = false },properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(modifier = Modifier.wrapContentHeight().fillMaxWidth().background(color=White),shape=RectangleShape) {
                Column(modifier = Modifier) {
                    OutlinedTextField(
                        value = scheduleName,
                        onValueChange = { scheduleName = it },
                        label = { Text("작업 이름") },
                        //ai 사용
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            disabledBorderColor = Color.Transparent,
                            errorBorderColor = Color.Transparent
                        )
                    )
                    OutlinedTextField(
                        value = scheduleDescription,
                        onValueChange = { scheduleDescription = it },
                        label = { Text("작업 해설") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            disabledBorderColor = Color.Transparent,
                            errorBorderColor = Color.Transparent
                        )
                    )
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_send),
                            contentDescription = "flyer",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable() { showDS = true }
                        )
                    }
                }
            }
        }
    }
    if (showDS) {
        Dialog(onDismissRequest = { showTS = false },properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(modifier = Modifier.fillMaxWidth().wrapContentHeight().background(color=White),shape=RectangleShape) {
                Column() {
                    val datePickerState = rememberDatePickerState()
                    val currentTime = Calendar.getInstance()
                    Column {
                        DatePicker(
                            state = datePickerState,
                            headline = {
                                dateFormatter()
                            }
                            )
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Button(
                            onClick = {}, //무슨 기능인지 몰라서 안 넣었습니다
                            modifier=Modifier.size(150.dp, 50.dp),
                            colors = buttonColors(
                                contentColor = customColor,
                                containerColor = bgc
                            )
                        ) {
                            Text(
                                text="add Time"
                            )
                        }
                        Spacer(modifier = Modifier.size(15.dp))
                        Button(
                            onClick = { scheduleDate = formatSelectedDate(datePickerState.selectedDateMillis);showTS = true},
                            modifier=Modifier.size(150.dp, 50.dp),
                            colors = buttonColors(
                                contentColor = bgc,
                                containerColor = customColor
                            )
                        ) {
                            Text(
                                text="Reschedule"
                            )
                        }
                    }
                }
            }
        }
    }
    if (showTS) {
        Dialog(
            onDismissRequest = { showTS = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().background(color = White),
                shape = RectangleShape
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    val currentTime = Calendar.getInstance()
                    val timePickerState = rememberTimePickerState(
                        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
                        initialMinute = currentTime.get(Calendar.MINUTE),
                        is24Hour = true,
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        TimePicker(
                            state = timePickerState,
                            modifier = Modifier.fillMaxWidth(),
                            colors = TimePickerColors(
                                clockDialColor = Milk,
                                timeSelectorSelectedContainerColor = customColor,
                                timeSelectorUnselectedContainerColor = customColor, //위 숫자 배경
                                timeSelectorSelectedContentColor = White,
                                timeSelectorUnselectedContentColor = White, //위 숫자 글자
                                periodSelectorSelectedContainerColor = customColor,
                                periodSelectorUnselectedContainerColor = customColor,
                                periodSelectorSelectedContentColor = White,
                                periodSelectorUnselectedContentColor = White,
                                periodSelectorBorderColor = White,
                                selectorColor = customColor,
                                clockDialSelectedContentColor = White,
                                clockDialUnselectedContentColor = Black,
                                containerColor = customColor
                            )
                        )
                    }
                    Row(modifier = Modifier.background(color=bgc)) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Button(
                                onClick = {
                                    scheduleTime = if (timePickerState.hour < 10) {
                                        "0"
                                    } else {
                                        ""
                                    } + timePickerState.hour.toString() + ":" + if (timePickerState.minute < 10) {
                                        "0"
                                    } else {
                                        ""
                                    } + timePickerState.minute.toString()
                                    scope.launch {
                                        scheduleDao.insert(
                                            Schedule(
                                                id = 0,
                                                name = scheduleName,
                                                description = scheduleDescription,
                                                date = scheduleDate,
                                                time = scheduleTime
                                            )
                                        )
                                        refreshSC()
                                        showTF = false
                                        showDS = false
                                        showTS = false
                                    }
                                },
                                modifier = Modifier.size(150.dp, 50.dp),
                                colors = buttonColors(
                                    contentColor = customColor,
                                    containerColor = bgc
                                )
                            ) {
                                Text(
                                    text = "OK"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
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
                            showTF=true
//                            scope.launch {
//                                scheduleDao.insert(
//                                    Schedule(
//                                        id = 0,
//                                        name = scheduleName,
//                                        description = scheduleDescription,
//                                        date = scheduleDate,
//                                        time = scheduleTime
//                                    )
//                                )
//                                println(scheduleDao.getAll()) //DB 작동 테스트용
//                                refreshSC()
//                            }
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
                Text(text="Tap plus to create a new task", fontWeight = Bold, color=Black)
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
                    Text(text = "Today . ${formatSelectedDate(System.currentTimeMillis())}", color = Gray, fontSize = 15.sp)
                }
            }
        }
    }
}
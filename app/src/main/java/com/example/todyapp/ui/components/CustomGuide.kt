package com.example.todyapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todyapp.room.ColorDAO
import com.example.todyapp.room.ThemeColor
import com.example.todyapp.ui.theme.Milk
import com.example.todyapp.ui.theme.White
import com.example.todyapp.ui.theme.bgc
import com.example.todyapp.ui.theme.toThemeName
import kotlinx.coroutines.launch

@Composable
fun CustomGuide(
    customColor: Color,
    colorDao: ColorDAO,
    refresh: ()->Unit
) {
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(40.dp,3.dp)
            .shadow(5.dp, RoundedCornerShape(20.dp))
            .clickable {
                scope.launch {
                colorDao.screenSelectColor(ThemeColor(id = 0, selectedColor = customColor.toThemeName()))
                    refresh()
                }
            }) {
        Column()
        {
            Box(modifier = Modifier
                .fillMaxWidth()
                .size(36.dp)
                .background(color = customColor))
            Spacer(modifier = Modifier.fillMaxWidth().size(10.dp).background(color=bgc))
            Row(modifier = Modifier
                .fillMaxSize()
                .background(color = White)) {
                Canvas(
                    modifier = Modifier.size(60.dp),
                    onDraw = {
                        drawCircle(
                            color = Milk,
                            radius = 20.dp.toPx(),
                            center = Offset(25.dp.toPx(), 25.dp.toPx())
                        )
                    })
                Column {
                    Spacer(Modifier.padding(5.dp))
                    Canvas(
                        modifier = Modifier.size(230.dp, 5.dp),
                        onDraw = {
                            drawRect(color = Milk)
                        }
                    )
                    Spacer(Modifier.padding(5.dp))
                    Canvas(
                        modifier = Modifier.size(190.dp, 5.dp),
                        onDraw = {
                            drawRect(color = Milk)
                        }
                    )
                    Spacer(Modifier.padding(5.dp))
                    Canvas(
                        modifier = Modifier.size(250.dp, 5.dp),
                        onDraw = {
                            drawRect(color = Milk)
                        }
                    )
                }
            }
        }
    }
}
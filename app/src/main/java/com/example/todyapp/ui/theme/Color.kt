package com.example.todyapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green

fun String.toThemeColor(): Color = when (this) {
    "Green" -> Greenx
    "Red" -> Red
    "Blue" -> Blue
    "Black" -> Black
    else  -> Green
}

fun Color.toThemeName(): String = when (this) {
    Greenx -> "Green"
    Red   -> "Red"
    Blue  -> "Blue"
    Black -> "Black"
    else  -> "Green"
}

val Greenx = Color(0xFF24A19C)
val Red = Color(0xFFEA4335)
val Blue = Color(0xFF1877F2)
val Black = Color(0xFF1B1C1F)
val White = Color(0xFFFFFFFF)
val Gray = Color(0xFFA0AAB8)

val Milk = Color(0xFFE7ECF5)

val bgc = Color(0xFFFFFFFF)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
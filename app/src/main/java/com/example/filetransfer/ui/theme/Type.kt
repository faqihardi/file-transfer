package com.example.filetransfer.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.filetransfer.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium)
)

val Typography = Typography(
    headlineSmall = TextStyle(
        fontFamily = Poppins, fontSize = 24.sp, lineHeight = 32.sp, fontWeight = FontWeight.Medium
    ),
    titleLarge = TextStyle(
        fontFamily = Poppins, fontSize = 22.sp, lineHeight = 28.sp, fontWeight = FontWeight.Medium
    ),
    titleMedium = TextStyle(
        fontFamily = Poppins, fontSize = 16.sp, lineHeight = 24.sp, fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppins, fontSize = 16.sp, lineHeight = 24.sp, fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins, fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = Poppins, fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium
    ),
    labelSmall = TextStyle(
        fontFamily = Poppins, fontSize = 11.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium
    )
)
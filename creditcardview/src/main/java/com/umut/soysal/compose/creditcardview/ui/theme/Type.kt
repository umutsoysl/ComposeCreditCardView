package com.umut.soysal.compose.creditcardview.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.umut.soysal.compose.creditcardview.R

private val customFonts = FontFamily(
    Font(R.font.cordale_bd),
)

@ExperimentalUnitApi
val typography = Typography(
    defaultFontFamily = customFonts,
    h1 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Light,
        fontFamily = customFonts,
    letterSpacing = TextUnit(2.2F, TextUnitType.Sp)),
    h2 = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal,
        color = Color.White, fontFamily = customFonts),
    h3 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal,
        color = Color.White, fontFamily = customFonts),
    h4 = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Light,
        fontFamily = customFonts,
        letterSpacing = TextUnit(1.5F, TextUnitType.Sp)),
    h5 = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Light,
        fontFamily = customFonts,
        letterSpacing = TextUnit(1.5F, TextUnitType.Sp)),
)
package com.sopt.korailtalk.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

//Primary-Blue
val Blue01 = Color(0xFF063B62)
val Blue02 = Color(0xFF035795)
val Blue03 = Color(0xFF0B6CB6)
val Blue04 = Color(0xFF3284C2)
val Blue05 = Color(0xFF68A7D5)
val Blue06 = Color(0xFFC1E1FA)
val Blue07 = Color(0xFFEBF6FF)

//Secondary-Purple
val Purple01 = Color(0xFF47346C)
val Purple02 = Color(0xFF673BB7)
val Purple03 = Color(0xFF7D43E8)
val Purple04 = Color(0xFF9747FF)
val Purple05 = Color(0xFFF5EDFF)

//GrayScale
val Grey25 = Color(0xFFFCFCFD)
val Grey50 = Color(0xFFF9FAFB)
val Grey100 = Color(0xFFF3F4F6)
val Grey200 = Color(0xFFE5E7EB)
val Grey300 = Color(0xFFD2D6DB)
val Grey400 = Color(0xFF9DA4AE)
val Grey500 = Color(0xFF6C737F)
val Grey600 = Color(0xFF4D5761)
val Grey700 = Color(0xFF384250)
val Grey800 = Color(0xFF1F2A37)
val Grey900 = Color(0xFF111927)
val Grey950 = Color(0xFF0D121C)

//Red
val Red = Color(0xFFFF4343)

//Transparent/BG
val TransparentWhite10 = Color(0x1AFFFFFF)
val TransparentBlue50 = Color(0x8094BFDF)
val TransparentBlue95 = Color(0xF2253A4A)
val TransparentBlack50 = Color(0xB2000000)

@Immutable
data class KorailTalkColors(
    val White: Color,
    val Black: Color,

    //Primary-Blue
    val Blue01: Color,
    val Blue02: Color,
    val Blue03: Color,
    val Blue04: Color,
    val Blue05: Color,
    val Blue06: Color,
    val Blue07: Color,

    //Secondary-Purple
    val Purple01: Color,
    val Purple02: Color,
    val Purple03: Color,
    val Purple04: Color,
    val Purple05: Color,

    //GrayScale
    val Grey25: Color,
    val Grey50: Color,
    val Grey100: Color,
    val Grey200: Color,
    val Grey300: Color,
    val Grey400: Color,
    val Grey500: Color,
    val Grey600: Color,
    val Grey700: Color,
    val Grey800: Color,
    val Grey900: Color,
    val Grey950: Color,

    //Red
    val Red: Color,

    //Transparent/BG
    val TransparentWhite10: Color,
    val TransparentBlue50: Color,
    val TransparentBlue95: Color,
    val TransparentBlack50: Color,
)

val defaultKorailTalkColors = KorailTalkColors(
    White = White,
    Black = Black,

    //Primary-Blue
    Blue01 = Blue01,
    Blue02 = Blue02,
    Blue03 = Blue03,
    Blue04 = Blue04,
    Blue05 = Blue05,
    Blue06 = Blue06,
    Blue07 = Blue07,

    //Secondary-Purple
    Purple01 = Purple01,
    Purple02 = Purple02,
    Purple03 = Purple03,
    Purple04 = Purple04,
    Purple05 = Purple05,

    //GrayScale
    Grey25 = Grey25,
    Grey50 = Grey50,
    Grey100 = Grey100,
    Grey200 = Grey200,
    Grey300 = Grey300,
    Grey400 = Grey400,
    Grey500 = Grey500,
    Grey600 = Grey600,
    Grey700 = Grey700,
    Grey800 = Grey800,
    Grey900 = Grey900,
    Grey950 = Grey950,

    //Red
    Red = Red,

    //Transparent/BG
    TransparentWhite10 = TransparentWhite10,
    TransparentBlue50 = TransparentBlue50,
    TransparentBlue95 = TransparentBlue95,
    TransparentBlack50 = TransparentBlack50
)

val LocalColors = staticCompositionLocalOf { defaultKorailTalkColors }
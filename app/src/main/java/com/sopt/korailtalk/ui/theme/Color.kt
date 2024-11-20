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
    val white: Color,
    val black: Color,

    //Primary-Blue
    val blue01: Color,
    val blue02: Color,
    val blue03: Color,
    val blue04: Color,
    val blue05: Color,
    val blue06: Color,
    val blue07: Color,

    //Secondary-Purple
    val purple01: Color,
    val purple02: Color,
    val purple03: Color,
    val purple04: Color,
    val purple05: Color,

    //GrayScale
    val grey25: Color,
    val grey50: Color,
    val grey100: Color,
    val grey200: Color,
    val grey300: Color,
    val grey400: Color,
    val grey500: Color,
    val grey600: Color,
    val grey700: Color,
    val grey800: Color,
    val grey900: Color,
    val grey950: Color,

    //Red
    val red: Color,

    //Transparent/BG
    val transparentWhite10: Color,
    val transparentBlue50: Color,
    val transparentBlue95: Color,
    val transparentBlack50: Color,
)

val defaultKorailTalkColors = KorailTalkColors(
    white = White,
    black = Black,

    //Primary-Blue
    blue01 = Blue01,
    blue02 = Blue02,
    blue03 = Blue03,
    blue04 = Blue04,
    blue05 = Blue05,
    blue06 = Blue06,
    blue07 = Blue07,

    //Secondary-Purple
    purple01 = Purple01,
    purple02 = Purple02,
    purple03 = Purple03,
    purple04 = Purple04,
    purple05 = Purple05,

    //GrayScale
    grey25 = Grey25,
    grey50 = Grey50,
    grey100 = Grey100,
    grey200 = Grey200,
    grey300 = Grey300,
    grey400 = Grey400,
    grey500 = Grey500,
    grey600 = Grey600,
    grey700 = Grey700,
    grey800 = Grey800,
    grey900 = Grey900,
    grey950 = Grey950,

    //Red
    red = Red,

    //Transparent/BG
    transparentWhite10 = TransparentWhite10,
    transparentBlue50 = TransparentBlue50,
    transparentBlue95 = TransparentBlue95,
    transparentBlack50 = TransparentBlack50
)

val LocalColors = staticCompositionLocalOf { defaultKorailTalkColors }
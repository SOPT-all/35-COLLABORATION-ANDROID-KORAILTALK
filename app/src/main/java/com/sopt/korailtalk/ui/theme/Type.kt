package com.sopt.korailtalk.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.sopt.korailtalk.R

val PretendardSemi = FontFamily(Font(R.font.pretendard_semibold))
val PretendardMedium = FontFamily(Font(R.font.pretendard_medium))
val PretendardRegular = FontFamily(Font(R.font.pretendard_regular))

@Immutable
data class KorailTalkTypography(
    //head
    val head1: TextStyle,
    val head2: TextStyle,
    val head3: TextStyle,
    val head4: TextStyle,
    val head5: TextStyle,

    //title
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,

    //body
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,

    //caption
    val caption1: TextStyle,
    val caption2: TextStyle,
    val caption3: TextStyle,
    val caption4: TextStyle,
)

val defaultKorailTalkTypography = KorailTalkTypography(
    //head
    head1 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 32.sp,
        lineHeight = 38.sp
    ),
    head2 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 28.sp,
        lineHeight = 34.sp
    ),
    head3 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 26.sp,
        lineHeight = 30.sp
    ),
    head4 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 22.sp,
        lineHeight = 26.sp
    ),
    head5 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),

    //title
    title1 = TextStyle(
        fontFamily = PretendardSemi,
        fontSize = 18.sp,
        lineHeight = 20.sp
    ),
    title2 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 18.sp,
        lineHeight = 20.sp
    ),
    title3 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),

    //body
    body1 = TextStyle(
        fontFamily = PretendardSemi,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    body3 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 14.sp,
        lineHeight = 14.sp
    ),

    //caption
    caption1 = TextStyle(
        fontFamily = PretendardSemi,
        fontSize = 12.sp,
        lineHeight = 14.sp
    ),
    caption2 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 12.sp,
        lineHeight = 14.sp
    ),
    caption3 = TextStyle(
        fontFamily = PretendardSemi,
        fontSize = 10.sp,
        lineHeight = 12.sp
    ),
    caption4 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 10.sp,
        lineHeight = 12.sp
    )
)

val LocalTypo = staticCompositionLocalOf { defaultKorailTalkTypography }
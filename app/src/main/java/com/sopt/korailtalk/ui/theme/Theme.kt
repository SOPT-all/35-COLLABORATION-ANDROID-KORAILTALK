package com.sopt.korailtalk.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object KorailTalkTheme {
    val colors: KorailTalkColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: KorailTalkTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypo.current
}

@Composable
fun ProvideKorailTalkColorsAndTypography(
    colors: KorailTalkColors,
    typography: KorailTalkTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypo provides typography,
        content = content
    )
}

@Composable
fun _35COLLAVORATIONANDROIDKORAILTALKTheme(
    backgroundColor: Color = defaultKorailTalkColors.White,
    content: @Composable () -> Unit
) {
    ProvideKorailTalkColorsAndTypography(
        colors = defaultKorailTalkColors,
        typography = defaultKorailTalkTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = backgroundColor.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }

        MaterialTheme(
            content = content
        )
    }
}
package com.sopt.korailtalk.presentation.ui.traincheck.component

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun TrainCheckNotice(
    text: String,
    style: TextStyle,
    color: Color = KorailTalkTheme.colors.grey500,
    paddingBottom: Dp = 8.dp) {
    Text(
        text = text,
        modifier = Modifier.padding(bottom = paddingBottom),
        color = color,
        style = style
    )
}

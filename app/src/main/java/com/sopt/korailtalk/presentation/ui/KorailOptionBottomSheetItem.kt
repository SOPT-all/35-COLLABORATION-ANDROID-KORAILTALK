package com.sopt.korailtalk.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun KorailOptionBottomSheetItem(
    isActive: Boolean,
    activeBgColor: Color,
    activeContentColor: Color,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isActive) activeBgColor else KorailTalkTheme.colors.white
            )
            .clickable {
                onClick()
            }
            .padding(vertical = 10.dp, horizontal = 22.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "모든열차",
            style = KorailTalkTheme.typography.title3.copy(
                color = if (isActive) activeContentColor else KorailTalkTheme.colors.black
            )
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        if (isActive) {
            Image(
                painter = painterResource(R.drawable.icn_check),
                colorFilter = ColorFilter.tint(
                    color = activeContentColor
                ),
                contentDescription = "체크"
            )
        }
    }
}
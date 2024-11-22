package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun MyTicketButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = KorailTalkTheme.colors.blue07,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .clickable {
                onClick()
            }
            .padding(vertical = 17.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = KorailTalkTheme.typography.title3.copy(
                color = KorailTalkTheme.colors.blue01
            ),
        )
    }
}
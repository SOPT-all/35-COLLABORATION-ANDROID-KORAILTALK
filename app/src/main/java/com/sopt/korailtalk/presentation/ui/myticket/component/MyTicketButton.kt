package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
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

@Preview(showBackground = true)
@Composable
fun ShowMyTicketButton() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val myTicketButtonText = listOf("승차권 전달", "예매 취소", "예매 변경")

                myTicketButtonText.forEach { text ->
                    MyTicketButton(
                        text = text,
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
    }
}
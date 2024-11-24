package com.sopt.korailtalk.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun KorailChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .width(106.dp)
            .background(
                color = KorailTalkTheme.colors.blue02,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(horizontal = 7.dp, vertical = 3.dp)
    ) {
        Text(
            text = text,
            style = KorailTalkTheme.typography.caption2.copy(color = KorailTalkTheme.colors.white)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowKorailChip() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            val chipNames = listOf("KTX 001", "KTX 003")

            chipNames.forEach { name ->
                KorailChip(
                    text = name
                )
            }
        }
    }
}
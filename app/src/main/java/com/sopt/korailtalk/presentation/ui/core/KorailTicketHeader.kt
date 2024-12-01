package com.sopt.korailtalk.presentation.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography

@Composable
fun KorailTicketHeader(
    date: String,
    trainName: String,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = KorailTalkTheme.colors.blue03,
            shape = RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 12.dp))
        .padding(horizontal = 16.dp, vertical = 12.dp)){
        Text(text = date,
            modifier = Modifier.align(Alignment.CenterStart),
            style = typography.title3,
            color = KorailTalkTheme.colors.white)

        KorailChip(
            text = trainName,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Preview
@Composable
fun KorailTicketHeaderPreview(){
    KorailTicketHeader("2024년 10월 30일 (수)", "KTX 001")
}
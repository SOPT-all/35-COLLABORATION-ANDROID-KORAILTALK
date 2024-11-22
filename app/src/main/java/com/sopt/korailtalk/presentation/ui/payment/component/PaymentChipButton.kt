package com.sopt.korailtalk.presentation.ui.payment.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentChipButton(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = KorailTalkTheme.colors.purple05
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 13.dp),
            color = KorailTalkTheme.colors.purple02,
            style = KorailTalkTheme.typography.caption1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentChipButton() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            PaymentChipButton(
                title = "전액적용",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(4.dp))

            PaymentChipButton(
                title = "보훈번호 확인",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(4.dp))

            PaymentChipButton(
                title = "조회하기",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(4.dp))

            PaymentChipButton(
                title = "카드스캔",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
package com.sopt.korailtalk.presentation.ui.payment.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentSquareButton(
    title: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = if (enabled) KorailTalkTheme.colors.purple03 else KorailTalkTheme.colors.grey200)
            .clickableWithoutRipple(
                enabled = enabled,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = KorailTalkTheme.colors.white,
            style = KorailTalkTheme.typography.title3
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentSquareButton() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            PaymentSquareButton(
                title = "마일리지 적용",
                enabled = false,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentSquareButton(
                title = "마일리지 적용",
                enabled = true,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))
            PaymentSquareButton(
                title = "할인 적용",
                enabled = false,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentSquareButton(
                title = "할인 적용",
                enabled = true,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))
            PaymentSquareButton(
                title = "포인트 적용",
                enabled = false,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentSquareButton(
                title = "포인트 적용",
                enabled = true,
                onClick = {}
            )
        }

    }
}
package com.sopt.korailtalk.presentation.ui.payment.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentHorizontalDiver() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 8.dp,
        color = KorailTalkTheme.colors.grey100
    )
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentHorizontalDivider() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
                    .background(color = KorailTalkTheme.colors.blue01)
            )
            PaymentHorizontalDiver()
            Box(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
                    .background(color = KorailTalkTheme.colors.blue01)
            )
        }

    }
}
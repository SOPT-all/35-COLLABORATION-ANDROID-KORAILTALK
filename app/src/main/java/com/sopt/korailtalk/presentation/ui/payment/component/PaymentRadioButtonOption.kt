package com.sopt.korailtalk.presentation.ui.payment.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
fun PaymentRadioButtonOption(
    title: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickableWithoutRipple(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .border(
                    width = 1.dp,
                    color = KorailTalkTheme.colors.grey200,
                    shape = CircleShape
                )
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            if (selected) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(color = KorailTalkTheme.colors.blue04, shape = CircleShape)
                )
            }
        }
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = title,
            modifier = Modifier.padding(vertical = 6.dp),
            color = KorailTalkTheme.colors.grey800,
            style = KorailTalkTheme.typography.body1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentRadioButtonOption() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            PaymentRadioButtonOption(
                title = "KTX 마일리지",
                selected = false,
                onClick = { }
            )

            Spacer(modifier = Modifier.height(16.dp))

            PaymentRadioButtonOption(
                title = "할인쿠폰",
                selected = false,
                onClick = { }
            )

            Spacer(modifier = Modifier.height(16.dp))

            PaymentRadioButtonOption(
                title = "포인트 사용",
                selected = false,
                onClick = { }
            )

            Spacer(modifier = Modifier.height(16.dp))

            PaymentRadioButtonOption(
                title = "간편결제",
                selected = false,
                onClick = { }
            )

            Spacer(modifier = Modifier.height(16.dp))

            PaymentRadioButtonOption(
                title = "카드결제",
                selected = false,
                onClick = { }
            )
        }
    }
}
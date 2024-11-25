package com.sopt.korailtalk.presentation.ui.payment.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.domain.type.PaymentDropdownOptionType
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentDropdownOption(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    description: String = "",
    state: PaymentDropdownOptionType = PaymentDropdownOptionType.UNSELECTED,
) {
    Box(
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = if (state == PaymentDropdownOptionType.UNENABLED) KorailTalkTheme.colors.grey100 else KorailTalkTheme.colors.white,
                borderColor = KorailTalkTheme.colors.grey200,
                borderWidth = if (state == PaymentDropdownOptionType.UNENABLED) 0.dp else 1.dp
            )
            .clickableWithoutRipple(
                enabled = state != PaymentDropdownOptionType.UNENABLED,
                onClick = onClick
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = if (state == PaymentDropdownOptionType.UNENABLED) KorailTalkTheme.colors.grey400 else KorailTalkTheme.colors.black,
                style = KorailTalkTheme.typography.caption2
            )
            Spacer(modifier = Modifier.weight(1f))
            if (description.isNotBlank()) {
                Text(
                    text = description,
                    modifier = Modifier.padding(end = 12.dp),
                    color = when (state) {
                        PaymentDropdownOptionType.UNENABLED -> KorailTalkTheme.colors.grey500
                        PaymentDropdownOptionType.UNSELECTED -> KorailTalkTheme.colors.grey400
                        PaymentDropdownOptionType.SELECTED -> KorailTalkTheme.colors.blue01
                        PaymentDropdownOptionType.APPLIED -> KorailTalkTheme.colors.purple03
                    },
                    style = if (state == PaymentDropdownOptionType.UNENABLED || state == PaymentDropdownOptionType.APPLIED)
                        KorailTalkTheme.typography.caption2 else KorailTalkTheme.typography.body2
                )
            }
            Image(
                painter = painterResource(
                    id = if (state == PaymentDropdownOptionType.UNENABLED) R.drawable.ic_payment_unenabled_arrowdown
                    else R.drawable.ic_payment_enabled_arrowdown
                ),
                contentDescription = null
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentDropdownOption() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            PaymentDropdownOption(
                title = "할인쿠폰",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))

            PaymentDropdownOption(
                title = "국가유공자",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "500원 할인",
                state = PaymentDropdownOptionType.APPLIED
            )
            Spacer(modifier = Modifier.height(8.dp))

            PaymentDropdownOption(
                title = "국가유공자 보호자 할인",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "적용대상 없음",
                state = PaymentDropdownOptionType.UNENABLED
            )
            Spacer(modifier = Modifier.height(8.dp))

            PaymentDropdownOption(
                title = "중증 보호자 할인",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "적용대상 없음",
                state = PaymentDropdownOptionType.UNENABLED
            )
            Spacer(modifier = Modifier.height(8.dp))

            PaymentDropdownOption(
                title = "현역병 할인",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            PaymentDropdownOption(
                title = "적용대상",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "적용할 승객을 선택해주세요"
            )
            Spacer(modifier = Modifier.height(8.dp))
            PaymentDropdownOption(
                title = "적용대상",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "어른 - 7호차 16A / 12,500원",
                state = PaymentDropdownOptionType.SELECTED
            )

            Spacer(modifier = Modifier.height(16.dp))

            PaymentDropdownOption(
                title = "자주쓰는카드",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "직접입력",
                state = PaymentDropdownOptionType.SELECTED
            )
            Spacer(modifier = Modifier.height(8.dp))
            PaymentDropdownOption(
                title = "카드종류",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "개인",
                state = PaymentDropdownOptionType.SELECTED
            )
            Spacer(modifier = Modifier.height(8.dp))
            PaymentDropdownOption(
                title = "할부기간",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                description = "일시불",
                state = PaymentDropdownOptionType.SELECTED
            )

        }

    }
}
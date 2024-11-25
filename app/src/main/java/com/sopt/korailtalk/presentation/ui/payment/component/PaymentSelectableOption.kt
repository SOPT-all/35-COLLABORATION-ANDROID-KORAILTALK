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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.domain.type.PaymentSelectableOptionType
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentSelectableOption(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = "",
    state: PaymentSelectableOptionType = PaymentSelectableOptionType.ENABLED,
    content: @Composable () -> Unit = {},
) {
    Box(
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = when (state) {
                    PaymentSelectableOptionType.UNENABLED -> KorailTalkTheme.colors.grey200
                    PaymentSelectableOptionType.ENABLED -> KorailTalkTheme.colors.white
                    PaymentSelectableOptionType.SELECTED -> KorailTalkTheme.colors.blue04
                },
                borderColor =
                if (state == PaymentSelectableOptionType.ENABLED) KorailTalkTheme.colors.grey200
                else Color.Transparent,
                borderWidth =
                if (state == PaymentSelectableOptionType.ENABLED) 1.dp
                else 0.dp
            )
            .clickableWithoutRipple(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (title.isNotBlank()) {
                Text(
                    text = title,
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = when (state) {
                        PaymentSelectableOptionType.UNENABLED -> KorailTalkTheme.colors.grey400
                        PaymentSelectableOptionType.ENABLED -> KorailTalkTheme.colors.black
                        PaymentSelectableOptionType.SELECTED -> KorailTalkTheme.colors.white
                    },

                    style = KorailTalkTheme.typography.caption2
                )
            }
            content()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowPaymentSelectableOption() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            PaymentSelectableOption(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                title = "L.POINT",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "레일포인트",
                )
                Spacer(modifier = Modifier.width(8.dp))
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "위바꿀 (모아)",
                    state = PaymentSelectableOptionType.UNENABLED
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "씨티포인트",
                    state = PaymentSelectableOptionType.UNENABLED,
                )
                Spacer(modifier = Modifier.width(8.dp))
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "OK캐쉬백포인트",
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            PaymentSelectableOption(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Row(
                        modifier = Modifier.padding(vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_payment_korail_logo),
                            contentDescription = null
                        )
                        Text(
                            text = "X",
                            modifier = Modifier.padding(horizontal = 4.dp),
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.head5
                        )
                        Image(
                            painter = painterResource(id = R.drawable.img_payment_tosspay_logo),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "+ 결제수단 등록하기",
                            color = KorailTalkTheme.colors.grey400,
                            style = KorailTalkTheme.typography.caption2
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "레일 플러스 카드"
                )
                Spacer(modifier = Modifier.width(8.dp))
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "네이버페이 (머니)",
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_payment_easypayment_event),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "제로페이카드",
                    state = PaymentSelectableOptionType.SELECTED,
                )
                Spacer(modifier = Modifier.width(8.dp))
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "네이버페이 (카드)",
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "KB Pay",
                )
                Spacer(modifier = Modifier.width(8.dp))
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "토스페이",
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "카카오페이",
                )
                Spacer(modifier = Modifier.width(8.dp))
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "신한SOL페이",
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "PAYCO",
                )
                Spacer(modifier = Modifier.width(8.dp))
                PaymentSelectableOption(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    title = "BC페이북",
                )
            }
        }
    }
}
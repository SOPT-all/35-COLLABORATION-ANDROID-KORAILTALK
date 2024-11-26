package com.sopt.korailtalk.presentation.ui.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailSingleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentHorizontalDiver
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentRadioButtonOption
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        KorailSingleActionTopAppBar(
            title = "결제하기",
            backgroundColor = KorailTalkTheme.colors.purple02,
            iconId = R.drawable.ic_topappbar_x_24,
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "승차권",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title1
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "12,500원",
                            color = KorailTalkTheme.colors.purple04,
                            style = KorailTalkTheme.typography.head3
                        )
                    }
                    Text(
                        text = "*특(우등)실은 운임과 요금으로 구성되며 운임만 할인됨",
                        color = KorailTalkTheme.colors.red,
                        style = KorailTalkTheme.typography.caption4
                    )
                }
            }

            item { PaymentHorizontalDiver() }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "할인",
                        color = KorailTalkTheme.colors.black,
                        style = KorailTalkTheme.typography.title1
                    )
                    PaymentRadioButtonOption(
                        title = "KTX 마일리지",
                        selected = false,
                        onClick = { }
                    )
                    PaymentRadioButtonOption(
                        title = "할인쿠폰",
                        selected = false,
                        onClick = { }
                    )
                    PaymentRadioButtonOption(
                        title = "포인트 사용",
                        selected = false,
                        onClick = { }
                    )
                }
            }

            item { PaymentHorizontalDiver() }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "결제수단 선택",
                        color = KorailTalkTheme.colors.black,
                        style = KorailTalkTheme.typography.title1
                    )
                    PaymentRadioButtonOption(
                        title = "간편결제",
                        selected = false,
                        onClick = { }
                    )
                    PaymentRadioButtonOption(
                        title = "카드결제",
                        selected = false,
                        onClick = { }
                    )
                }
            }

            item { PaymentHorizontalDiver() }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(bottom = 16.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = "결제 상세",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title1
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "어른 1명 - 1매",
                            color = KorailTalkTheme.colors.purple02,
                            style = KorailTalkTheme.typography.body2
                        )
                    }

                    Row(
                        modifier = Modifier.padding(bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "이용 금액",
                            color = KorailTalkTheme.colors.grey800,
                            style = KorailTalkTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "12,500원",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title3
                        )
                    }
                    Row(
                        modifier = Modifier.padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "할인 및 포인트",
                            color = KorailTalkTheme.colors.grey800,
                            style = KorailTalkTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "500원",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title3
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(color = KorailTalkTheme.colors.grey200)
                    )

                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "총 결제 금액",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title3
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "12,000원",
                            color = KorailTalkTheme.colors.purple04,
                            style = KorailTalkTheme.typography.head5
                        )
                    }
                }
            }

            item { PaymentHorizontalDiver() }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = KorailTalkTheme.colors.transparentBlue95)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "총 1매",
                    color = KorailTalkTheme.colors.purple05,
                    style = KorailTalkTheme.typography.body2
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "12,000원",
                    color = KorailTalkTheme.colors.white,
                    style =  KorailTalkTheme.typography.head5
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        KorailRoundedButton(
            title = "발권하기",
            modifier = Modifier
                .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            enabled = true,
            contentColor = KorailTalkTheme.colors.white,
            cornerRadius = 26.dp,
            backgroundColor = KorailTalkTheme.colors.purple03,
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentScreen() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        PaymentScreen()
    }
}
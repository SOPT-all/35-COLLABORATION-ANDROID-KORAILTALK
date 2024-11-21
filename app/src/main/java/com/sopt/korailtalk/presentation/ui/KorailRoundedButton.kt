package com.sopt.korailtalk.presentation.ui

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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun KorailRoundedButton(
    title: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentColor: Color,
    cornerRadius: Dp,
    backgroundColor: Color,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 0.dp,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = cornerRadius,
                backgroundColor = if (enabled) backgroundColor else KorailTalkTheme.colors.grey200,
                borderColor = borderColor,
                borderWidth = borderWidth
            )
            .clickableWithoutRipple(
                enabled = enabled,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = if (enabled) contentColor else KorailTalkTheme.colors.white,
            style = KorailTalkTheme.typography.title3
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowKorailRoundedButton() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp)
        ) {
            // View1 : 열차 조회

            KorailRoundedButton(
                title = "다음날 (11월 17일) 조회하기",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                enabled = true,
                contentColor = KorailTalkTheme.colors.blue01,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.white,
                borderColor = KorailTalkTheme.colors.grey200,
                borderWidth = 1.dp,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                KorailRoundedButton(
                    title = "좌석 선택",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                        .weight(1f),
                    enabled = true,
                    contentColor = KorailTalkTheme.colors.blue01,
                    cornerRadius = 26.dp,
                    backgroundColor = KorailTalkTheme.colors.white,
                    borderColor = KorailTalkTheme.colors.grey200,
                    borderWidth = 1.dp,
                )
                Spacer(modifier = Modifier.width(8.dp))
                KorailRoundedButton(
                    title = "자동 배정",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                        .weight(1f),
                    enabled = true,
                    contentColor = KorailTalkTheme.colors.white,
                    cornerRadius = 26.dp,
                    backgroundColor = KorailTalkTheme.colors.blue03,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // View2 : 좌석 선택

            KorailRoundedButton(
                title = "선택 완료",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                enabled = false,
                contentColor = KorailTalkTheme.colors.white,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.blue03,
            )

            Spacer(modifier = Modifier.height(16.dp))

            KorailRoundedButton(
                title = "선택 완료",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                enabled = true,
                contentColor = KorailTalkTheme.colors.white,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.blue03,
            )

            Spacer(modifier = Modifier.height(16.dp))

            // View3 : 승차권 정보 확인

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                KorailRoundedButton(
                    title = "담아 두기",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                        .weight(1f),
                    enabled = true,
                    contentColor = KorailTalkTheme.colors.blue01,
                    cornerRadius = 26.dp,
                    backgroundColor = KorailTalkTheme.colors.white,
                    borderColor = KorailTalkTheme.colors.grey200,
                    borderWidth = 1.dp
                )
                Spacer(modifier = Modifier.width(8.dp))
                KorailRoundedButton(
                    title = "바로결제",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                        .weight(1f),
                    enabled = true,
                    contentColor = KorailTalkTheme.colors.white,
                    cornerRadius = 26.dp,
                    backgroundColor = KorailTalkTheme.colors.blue03,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // View4 : 결제하기

            KorailRoundedButton(
                title = "발권하기",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                enabled = false,
                contentColor = KorailTalkTheme.colors.white,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.blue03,
            )

            Spacer(modifier = Modifier.height(16.dp))

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

            Spacer(modifier = Modifier.height(16.dp))

            // View5 : 나의 티켓

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KorailRoundedButton(
                    title = "열차정보",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.056).dp)
                        .width((LocalConfiguration.current.screenWidthDp * 0.764).dp),
                    enabled = true,
                    contentColor = KorailTalkTheme.colors.blue01,
                    cornerRadius = 26.dp,
                    backgroundColor = KorailTalkTheme.colors.white,
                    borderColor = KorailTalkTheme.colors.grey200,
                    borderWidth = 1.dp
                )
                // 공유 아이콘
            }

            Spacer(modifier = Modifier.height(16.dp))

            KorailRoundedButton(
                title = "부가서비스 더보기",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.056).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                enabled = true,
                contentColor = KorailTalkTheme.colors.blue01,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.white,
                borderColor = KorailTalkTheme.colors.grey200,
                borderWidth = 1.dp
            )
        }
    }
}



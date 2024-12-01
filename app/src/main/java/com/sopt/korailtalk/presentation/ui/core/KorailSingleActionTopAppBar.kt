package com.sopt.korailtalk.presentation.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun KorailSingleActionTopAppBar(
    title: String,
    backgroundColor: Color,
    iconId: Int,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .height(56.dp)

    ) {
        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            color = KorailTalkTheme.colors.white,
            style = KorailTalkTheme.typography.title1
        )
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickableWithoutRipple(onClick = onClick)
                .padding(10.dp),
            tint = KorailTalkTheme.colors.white
        )
    }
}

@Preview
@Composable
fun ShowKorailSingleActionButton() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column {
            KorailSingleActionTopAppBar(
                title = "승차권 정보 확인",
                backgroundColor = KorailTalkTheme.colors.blue01,
                iconId = R.drawable.ic_topappbar_x_24,
            )

            Spacer(modifier = Modifier.height(16.dp))

            KorailSingleActionTopAppBar(
                title = "결제하기",
                backgroundColor = KorailTalkTheme.colors.purple02,
                iconId = R.drawable.ic_topappbar_x_24,
            )

            Spacer(modifier = Modifier.height(16.dp))

            KorailSingleActionTopAppBar(
                title = "나의 티켓",
                backgroundColor = KorailTalkTheme.colors.blue01,
                iconId = R.drawable.ic_topappbar_menu_24,
            )
        }

    }
}

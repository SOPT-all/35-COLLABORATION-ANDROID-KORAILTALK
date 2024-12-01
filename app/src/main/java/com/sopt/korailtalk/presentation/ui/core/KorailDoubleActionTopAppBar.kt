package com.sopt.korailtalk.presentation.ui.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun KorailDoubleActionTopAppBar(
    title: String,
    backgroundColor: Color,
    primaryIconId: Int,
    secondaryIconId: Int,
    onPrimaryClick: () -> Unit = {},
    onSecondaryClick: () -> Unit = {},
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
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                painter = painterResource(id = primaryIconId),
                contentDescription = null,
                modifier = Modifier
                    .clickableWithoutRipple(onClick = onPrimaryClick)
                    .padding(10.dp),
                tint = KorailTalkTheme.colors.white
            )
            Icon(
                painter = painterResource(id = secondaryIconId),
                contentDescription = null,
                modifier = Modifier
                    .clickableWithoutRipple(onClick = onSecondaryClick)
                    .padding(10.dp),
                tint = KorailTalkTheme.colors.white
            )
        }
    }
}

@Preview
@Composable
fun ShowKorailDoubleActionTopAppBar() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column {
            KorailDoubleActionTopAppBar(
                title = "열차 조회",
                backgroundColor = KorailTalkTheme.colors.blue01,
                primaryIconId = R.drawable.ic_topappbar_reload_24,
                secondaryIconId = R.drawable.ic_topappbar_menu_24
            )

            Spacer(modifier = Modifier.height(16.dp))

            KorailDoubleActionTopAppBar(
                title = "좌석 선택",
                backgroundColor = KorailTalkTheme.colors.blue01,
                primaryIconId = R.drawable.ic_topappbar_reload_24,
                secondaryIconId = R.drawable.ic_topappbar_menu_24
            )
        }
    }
}
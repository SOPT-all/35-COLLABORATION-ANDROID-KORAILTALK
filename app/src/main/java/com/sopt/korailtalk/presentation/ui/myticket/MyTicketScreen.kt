package com.sopt.korailtalk.presentation.ui.myticket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketAdditionalService
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketAdditionalServiceType
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketButton
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketTabBar
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme

@Composable
fun MyTicketScreen() {
    val myTicketButtonText = listOf("승차권 전달", "예매 취소", "예매 변경")
    val myTicketTabText = listOf("승차권 (1)", "이용권", "정기권 · 패스")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            MyTicketTabBar(myTicketTabText = myTicketTabText)



            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                myTicketButtonText.forEach { text ->
                    MyTicketButton(
                        text = text,
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                for (item in MyTicketAdditionalServiceType.entries) {
                    MyTicketAdditionalService(
                        image = item.image,
                        text = item.text,
                        textColor = item.textColor,
                    )
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        MyTicketScreen()
    }
}
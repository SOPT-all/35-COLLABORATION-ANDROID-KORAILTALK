package com.sopt.korailtalk.presentation.ui.myticket

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.data.remote.model.response.TicketData
import com.sopt.korailtalk.domain.type.MyTicketTabType
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailSingleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicket
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketAdditionalService
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketAdditionalServiceType
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketTabBar
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun MyTicketScreen() {
    val myTicketTabText = MyTicketTabType.entries.toTypedArray()
    val ticketDummy = TicketData(
        departurePlace = "서울",
        arrivalPlace = "부산",
        date = "2024년 10월 30일 (수)",
        trainName = "KTX 001",
        departureTime = "09:30",
        arrivalTime = "12:45",
        seatName = "16A",
        ticketPrice = 50000,
        limitPaymentTime = "2024-11-30T18:00:00",
        coachesNumber = 4
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KorailTalkTheme.colors.grey100),
    ) {
        Column {
            KorailSingleActionTopAppBar(
                title = "나의 티켓",
                backgroundColor = KorailTalkTheme.colors.blue01,
                iconId = R.drawable.ic_topappbar_menu_24,
            )
            MyTicketTabBar(myTicketTabText = myTicketTabText)
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            MyTicket(
                ticketData = ticketDummy,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .roundedBackgroundWithBorder(
                        cornerRadius = 12.dp,
                        backgroundColor = KorailTalkTheme.colors.white,
                        borderColor = KorailTalkTheme.colors.white,
                        borderWidth = 0.dp
                    )
                    .padding(all = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "이런 서비스는 어떠세요?",
                    style = KorailTalkTheme.typography.body1.copy(
                        color = KorailTalkTheme.colors.grey700
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    for (item in MyTicketAdditionalServiceType.entries) {
                        MyTicketAdditionalService(
                            image = {
                                Image(
                                    painter = painterResource(item.imageId),
                                    contentDescription = item.text
                                )
                            },
                            text = item.text,
                            textColor = item.textColor,
                        )
                    }
                }
                KorailRoundedButton(
                    title = "부가서비스 더보기",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.056).dp)
                        .fillMaxWidth(),
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
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        MyTicketScreen()
    }
}
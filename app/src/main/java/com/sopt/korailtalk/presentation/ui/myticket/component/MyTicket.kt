package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.data.remote.model.response.TicketData
import com.sopt.korailtalk.domain.type.MyTicketButtonType
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailTicketHeader
import com.sopt.korailtalk.presentation.ui.KorailWayInfoWithTime
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun MyTicket(
    ticketData: TicketData,
    modifier: Modifier = Modifier
) {
    val myTicketButtonText = MyTicketButtonType.entries.toTypedArray()

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        KorailTicketHeader(
            date = ticketData.date,
            trainName = ticketData.trainName
        )
        Box {
            Image(
                painter = painterResource(R.drawable.img_ticket_bg),
                contentDescription = "티켓",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Column {
                KorailWayInfoWithTime(
                    modifier = Modifier
                        .padding(30.dp),
                    departurePlace = ticketData.departurePlace,
                    arrivalPlace = ticketData.arrivalPlace,
                    departureTime = ticketData.departureTime,
                    arrivalTime = ticketData.arrivalTime
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
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
                    Spacer(
                        modifier = Modifier
                            .width(8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .border(1.dp, color = KorailTalkTheme.colors.grey200, CircleShape)
                            .background(color = KorailTalkTheme.colors.white)
                            .clickableWithoutRipple {}
                            .padding(all = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_ticket_share),
                            contentDescription = "공유"
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(36.dp)
                )
                MyTicketInfomation(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    coachesNumber = ticketData.coachesNumber,
                    seatName = ticketData.seatName,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    myTicketButtonText.forEach { enum ->
                        MyTicketButton(
                            text = enum.text,
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMyTicket() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = KorailTalkTheme.colors.grey100)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            MyTicket(
                ticketData = TicketData(
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
            )
        }
    }
}
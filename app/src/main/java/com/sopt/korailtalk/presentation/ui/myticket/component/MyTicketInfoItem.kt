package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.domain.model.TicketData
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun MyTicketInfoItem(
    title: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height((LocalConfiguration.current.screenHeightDp * 0.104).dp)
    ) {
        Text(
            text = title,
            style = KorailTalkTheme.typography.caption1.copy(
                color = KorailTalkTheme.colors.black
            ),
        )
        Box(
            modifier = Modifier
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
fun MyTicketInfomation(
    ticketData: TicketData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MyTicketInfoItem(
            title = "승차권",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_ticket_refresh_l),
                        contentDescription = stringResource(R.string.my_ticket_refresh)
                    )
                    Text(
                        text = "15분전에\n표시됩니다",
                        style = KorailTalkTheme.typography.caption1.copy(
                            color = KorailTalkTheme.colors.blue02
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            },
        )
        VerticalDivider(
            thickness = 2.dp,
            color = KorailTalkTheme.colors.grey100
        )
        MyTicketInfoItem(
            title = "호차번호",
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = ticketData.coachesNumber.toString(),
                        style = KorailTalkTheme.typography.head2.copy(
                            color = KorailTalkTheme.colors.blue02
                        )
                    )
                    Text(
                        text = "호차",
                        style = KorailTalkTheme.typography.body1.copy(
                            color = KorailTalkTheme.colors.blue02
                        )
                    )
                }
            },
        )
        VerticalDivider(
            thickness = 2.dp,
            color = KorailTalkTheme.colors.grey100
        )
        MyTicketInfoItem(
            title = "좌석번호",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = ticketData.seatName,
                        style = KorailTalkTheme.typography.head2.copy(
                            color = KorailTalkTheme.colors.blue02
                        )
                    )
                    Text(
                        text = "창측",
                        style = KorailTalkTheme.typography.body2.copy(
                            color = KorailTalkTheme.colors.blue02
                        )
                    )
                }
            },
        )
        VerticalDivider(
            thickness = 2.dp,
            color = KorailTalkTheme.colors.grey100
        )
        MyTicketInfoItem(
            title = "운임영수증",
            content = {
                Image(
                    painter = painterResource(R.drawable.img_ticket_qr),
                    contentDescription = stringResource(R.string.my_ticket_receipt),
                    modifier = Modifier
                        .width((LocalConfiguration.current.screenWidthDp * 0.133).dp),
                    contentScale = ContentScale.FillWidth
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMyTicketInfomation() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            MyTicketInfomation(
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
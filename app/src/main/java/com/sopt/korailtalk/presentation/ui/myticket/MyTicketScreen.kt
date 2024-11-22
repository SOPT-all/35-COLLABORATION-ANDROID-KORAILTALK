package com.sopt.korailtalk.presentation.ui.myticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

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

            MyTicketInfomation(
                coachesNumber = 4,
                seatName = "16A"
            )

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
                for (item in AdditionalServiceItem.entries) {
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

@Composable
private fun MyTicketInfomation(
    coachesNumber: Int,
    seatName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MyTicketInfoItem(
            title = "승차권",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_ticket_refresh_l),
                        contentDescription = "리프레시"
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
        MyTicketInfoItem(
            title = "호차번호",
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = coachesNumber.toString(),
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
        MyTicketInfoItem(
            title = "좌석번호",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = seatName,
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
        MyTicketInfoItem(
            title = "운임영수증",
            content = {
                Image(
                    painter = painterResource(R.drawable.img_ticket_qr),
                    contentDescription = "영수증"
                )
            },
        )
    }
}

@Composable
fun MyTicketTabBar(
    myTicketTabText: List<String>,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = KorailTalkTheme.colors.white,
        contentColor = KorailTalkTheme.colors.white,
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = KorailTalkTheme.colors.blue01
            )
        },
        divider = {}
    ) {
        myTicketTabText.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                text = {
                    Text(
                        text = tab,
                        style = KorailTalkTheme.typography.title1,
                        color = if (selectedTabIndex == index) KorailTalkTheme.colors.blue01 else KorailTalkTheme.colors.grey400,
                    )
                }
            )
        }

    }
}

enum class AdditionalServiceItem(
    val image: @Composable () -> Unit,
    val text: String,
    val textColor: @Composable () -> Color
) {
    REPORT(
        image = {
            Image(
                painter = painterResource(R.drawable.ic_ticket_report),
                contentDescription = "철도범죄신고"
            )
        },
        text = "철도범죄신고",
        textColor = { KorailTalkTheme.colors.grey500 }
    ),
    HELP(
        image = {
            Image(
                painter = painterResource(R.drawable.ic_ticket_help),
                contentDescription = "승하차 도우미 신청"
            )
        },
        text = "승하차 도우미 신청",
        textColor = { KorailTalkTheme.colors.grey300 }
    ),
    SMS(
        image = {
            Image(
                painter = painterResource(R.drawable.ic_ticket_sms),
                contentDescription = "보호자 안심 SMS"
            )
        },
        text = "보호자 안심 SMS",
        textColor = { KorailTalkTheme.colors.grey300 }
    )
}

@Composable
fun MyTicketAdditionalService(
    image: @Composable () -> Unit,
    text: String,
    textColor: @Composable () -> Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 4.dp, bottom = 8.dp)
    ) {
        image()
        Text(
            text = text,
            style = KorailTalkTheme.typography.caption1.copy(
                color = textColor()
            ),
        )
    }
}

@Composable
fun MyTicketButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = KorailTalkTheme.colors.blue07,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .clickable {
                onClick()
            }
            .padding(vertical = 17.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = KorailTalkTheme.typography.title3.copy(
                color = KorailTalkTheme.colors.blue01
            ),
        )
    }
}

@Composable
fun MyTicketInfoItem(
    title: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = title,
            style = KorailTalkTheme.typography.caption1.copy(
                color = KorailTalkTheme.colors.black
            ),
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        MyTicketScreen()
    }
}
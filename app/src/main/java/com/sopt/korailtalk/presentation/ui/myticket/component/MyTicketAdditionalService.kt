package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

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
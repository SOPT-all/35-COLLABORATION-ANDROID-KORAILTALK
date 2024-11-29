package com.sopt.korailtalk.presentation.ui.traincheck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.ui.KorailDialog
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailSingleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.KorailTicketHeader
import com.sopt.korailtalk.presentation.ui.KorailWayInfoWithTime
import com.sopt.korailtalk.presentation.ui.traincheck.component.TrainCheckDetailInfo
import com.sopt.korailtalk.presentation.ui.traincheck.component.TrainCheckDialogContent
import com.sopt.korailtalk.presentation.ui.traincheck.component.TrainCheckNotice
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography

@Composable
fun TrainCheckScreen(
    userId: Long = 1,
    ticketId: Long = 1,
    navigateToPayment: () -> Unit,
) {
    val viewModel: TrainCheckViewModel = viewModel()
    val showDialog = viewModel.showDialog
    val ticketData by viewModel.ticketData.collectAsState()

    LaunchedEffect(true) {
        viewModel.getTicketInformation(userId, ticketId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KorailTalkTheme.colors.grey100)
    ) {
        KorailSingleActionTopAppBar(
            title = "승차권 정보 확인",
            backgroundColor = KorailTalkTheme.colors.blue01,
            iconId = R.drawable.ic_topappbar_x_24,
        )

        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Column(modifier = Modifier
                .padding(vertical = 8.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .background(color = KorailTalkTheme.colors.white)
            ) {
                KorailTicketHeader(ticketData.date, ticketData.trainName)

                KorailWayInfoWithTime(ticketData.departurePlace,
                    ticketData.arrivalPlace,
                    ticketData.departureTime,
                    ticketData.arrivalTime)

                HorizontalDivider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                    thickness = 1.dp, color = KorailTalkTheme.colors.grey200)

                Column (modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)){
                    TrainCheckDetailInfo(R.string.trainCheckDetailInfo_ticket) {
                        Text(text = "어른 1명",
                            color = KorailTalkTheme.colors.black,
                            style = typography.body1,
                        )
                    }
                    TrainCheckDetailInfo(R.string.trainCheckDetailInfo_seat) {
                        Text(text = buildAnnotatedString {
                            append(ticketData.coachesNumber.toString())
                            append("호차 ")
                            append(ticketData.seatName)
                        },
                            color = KorailTalkTheme.colors.black,
                            style = typography.body1)
                    }
                    TrainCheckDetailInfo(R.string.trainCheckDetailInfo_ticketPrice) {
                        Text(text = buildAnnotatedString {
                            append(ticketData.ticketPrice.toString())
                            append("원")
                        },
                            color = KorailTalkTheme.colors.purple04,
                            style = typography.head5)
                    }

                    Text(text = "*특(우등)실은 운임과 요금으로 구성되며 운임만 할인됨",
                        modifier = Modifier.padding(vertical = 20.dp),
                        color = KorailTalkTheme.colors.red,
                        style = typography.caption2)
                }

                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(KorailTalkTheme.colors.purple05)
                            .padding(12.dp),
                    ) {
                        Row() {
                            Text(
                                text = stringResource(R.string.trainCheck_limit_time),
                                color = KorailTalkTheme.colors.purple02,
                                style = typography.caption1
                            )
                            Text(
                                text = ticketData.limitPaymentTime,
                                modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                                color = KorailTalkTheme.colors.purple02,
                                style = typography.caption1
                            )
                        }
                        Text(
                            text = stringResource(R.string.trainCheck_limit_time_notice),
                            color = KorailTalkTheme.colors.purple02,
                            style = typography.caption2
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(KorailTalkTheme.colors.white)
                    .padding(horizontal = 10.dp, vertical = 16.dp)
            ) {
                TrainCheckNotice(text = stringResource(id = R.string.trainCheck_notice_title), style = typography.caption1, paddingBottom = 8.dp)
                TrainCheckNotice(text = stringResource(id = R.string.trainCheck_notice_cancel), style = typography.caption2)
                TrainCheckNotice(text = stringResource(id = R.string.trainCheck_notice_confirm), style = typography.caption2)
                TrainCheckNotice(text = stringResource(id = R.string.trainCheck_notice_discount), style = typography.caption2, paddingBottom = 0.dp)
            }
        }


        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(KorailTalkTheme.colors.white)
                .padding(10.dp)
        ) {
            KorailRoundedButton(
                title = stringResource(R.string.trainCheck_register),
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
                title = stringResource(R.string.trainCheck_pay),
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .weight(1f),
                enabled = true,
                contentColor = KorailTalkTheme.colors.white,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.blue03,
                onClick = { viewModel.toggleDialog(true) }
            )
        }
    }

    if (showDialog.value) {
        KorailDialog(
            title = stringResource(R.string.trainCheck_dialog_title),
            content = { TrainCheckDialogContent()},
            onConfirm = { viewModel.toggleDialog(false) }
        )
    }
}

@Preview
@Composable
fun TrainCheckScreenPreview(){
    TrainCheckScreen(1, 2, navigateToPayment = {})
}
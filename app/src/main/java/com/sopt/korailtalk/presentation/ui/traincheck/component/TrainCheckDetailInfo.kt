package com.sopt.korailtalk.presentation.ui.traincheck.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography
import com.sopt.korailtalk.ui.theme.LocalColors

@Composable
fun TrainCheckDetailInfo(
    type: Int,
    content: @Composable () -> Unit
) {
    // type에 따라 이미지 변경
    val image = when (type) {
        R.string.trainCheckDetailInfo_ticket -> R.drawable.icn_money
        R.string.trainCheckDetailInfo_seat -> R.drawable.ic_traincheck_seat_filled
        R.string.trainCheckDetailInfo_ticketPrice -> R.drawable.ic_traincheck_passenger_filled
        else -> R.drawable.icn_money
    }

    Row(
        modifier = Modifier.fillMaxWidth().background(LocalColors.current.white)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(type),
            modifier = Modifier.align(Alignment.CenterVertically).padding(vertical = 4.dp)
        )
        Text(
            text = stringResource(type),
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 6.dp),
            style = typography.body1
        )
        Spacer(modifier = Modifier.weight(1f))
        content()
    }
}

@Preview
@Composable
fun TrainCheckDetailInfoPreview(){
    TrainCheckDetailInfo(R.string.trainCheckDetailInfo_seat){
        Text(text = "12,500원",
            style = typography.head5,
            color = LocalColors.current.purple04,
        )
    }
}
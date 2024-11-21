package com.sopt.korailtalk.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography
import com.sopt.korailtalk.ui.theme.LocalColors

@Composable
fun KorailWayInfoWithTime(
    departurePlace: String,
    arrivalPlace: String,
    departureTime: String,
    arrivalTime: String,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = LocalColors.current.white)
        .padding(23.dp)){
        Column(
            modifier = Modifier.weight(1f),
        ){
            Text(text = departurePlace,
                modifier = Modifier.fillMaxWidth(),
                style = typography.head5,
                textAlign = TextAlign.Center
            )
            Text(text = departureTime,
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                color = LocalColors.current.grey600,
                style = typography.body3,
                textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(id = R.drawable.icn_arrow_circle),
            contentDescription = "열차 조회 화살표",
            modifier = Modifier.padding(horizontal = 26.dp).align(Alignment.CenterVertically)
        )
        Column(
            modifier = Modifier.weight(1f)
        ){
            Text(text = arrivalPlace,
                modifier = Modifier.fillMaxWidth(),
                style = typography.head5,
                textAlign = TextAlign.Center
            )
            Text(text = arrivalTime,
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                style = typography.body3,
                color = LocalColors.current.grey600,
                textAlign = TextAlign.Center
            )
        }
    }

}

@Preview
@Composable
fun KorailWayInfoWithTimePreview(){
    KorailWayInfoWithTime("서울", "부산", "18:32", "19:54")
}
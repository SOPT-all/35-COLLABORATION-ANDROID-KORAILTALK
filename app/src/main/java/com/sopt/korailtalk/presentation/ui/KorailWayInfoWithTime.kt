package com.sopt.korailtalk.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography

@Composable
fun KorailWayInfoWithTime(
    departurePlace: String,
    arrivalPlace: String,
    departureTime: String,
    arrivalTime: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(color = KorailTalkTheme.colors.white)
        .padding(23.dp),
        verticalAlignment = Alignment.CenterVertically){
        Column(
            modifier = Modifier.weight(1f),
        ){
            Text(text = departurePlace,
                modifier = Modifier.fillMaxWidth(),
                style = typography.head5,
                textAlign = TextAlign.Center
            )
            Text(text = departureTime,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                color = KorailTalkTheme.colors.grey600,
                style = typography.body3,
                textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_circle),
            contentDescription = stringResource(R.string.korailWayInfo_arrow_description),
            modifier = Modifier.padding(horizontal = 26.dp)
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                style = typography.body3,
                color = KorailTalkTheme.colors.grey600,
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
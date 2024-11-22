package com.sopt.korailtalk.presentation.ui.trainsearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun SearchWayInfoWithTravelTime(
    departureTime: String,
    arrivalTime: String,
    travelTime: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 39.dp)
    ) {
        SearchWayInfoItem(
            location = "서울",
            time = departureTime
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.icn_trainsearch_arrow_blue_right),
                contentDescription = "화살표"
            )
            Text(
                text = travelTime.toString(),
                style = KorailTalkTheme.typography.caption4.copy(
                    color = KorailTalkTheme.colors.grey500
                )
            )
        }
        SearchWayInfoItem(
            location = "부산",
            time = arrivalTime
        )
    }
}

@Composable
fun SearchWayInfoItem(
    location: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = location,
            style = KorailTalkTheme.typography.head5.copy(
                color = KorailTalkTheme.colors.black
            )
        )
        Text(
            text = time,
            style = KorailTalkTheme.typography.body3.copy(
                color = KorailTalkTheme.colors.black
            )
        )
    }
}
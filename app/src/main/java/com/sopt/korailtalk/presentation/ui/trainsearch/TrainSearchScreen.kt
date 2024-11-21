package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.ui.trainsearch.component.KorailChip
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun TrainSearchScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            KorailChip(
                text = "KTX 009",
            )
            SearchDepartureToArrival(
                departureTime = "05:13",
                arrivalTime = "07:13"
            )
        }
    }
}

@Composable
private fun SearchDepartureToArrival(
    departureTime: String,
    arrivalTime: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = departureTime,
            style = KorailTalkTheme.typography.title2.copy(color = KorailTalkTheme.colors.black)
        )
        Image(
            painter = painterResource(R.drawable.icn_trainsearch_arrow_right),
            contentDescription = "화살표"
        )
        Text(
            text = arrivalTime,
            style = KorailTalkTheme.typography.title2.copy(color = KorailTalkTheme.colors.black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        TrainSearchScreen()
    }
}
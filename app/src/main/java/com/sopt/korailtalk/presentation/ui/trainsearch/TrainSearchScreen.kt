package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.korailtalk.presentation.ui.KorailChip
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchDepartureToArrival
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainDateChipGroup
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainFilter
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchWayInfoWithTravelTime
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme

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

            SearchTrainFilter(
                date = "2024.11.16 (토)"
            )

            val chipList = listOf("11:08", "11:18", "11:28", "11:38")

            SearchTrainDateChipGroup(
                chipList = chipList
            )

            SearchWayInfoWithTravelTime(
                departureTime = "01:12",
                arrivalTime = "12:22",
                travelTime = 1010
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        TrainSearchScreen()
    }
}
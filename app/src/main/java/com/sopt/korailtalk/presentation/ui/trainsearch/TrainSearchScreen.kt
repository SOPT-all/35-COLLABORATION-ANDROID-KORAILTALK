package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.KorailChip
import com.sopt.korailtalk.presentation.ui.KorailOptionBottomSheetItem
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchDepartureToArrival
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainDateChipGroup
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainFilter
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchWayInfoWithTravelTime
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainSearchScreen() {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var isItemEnabled by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            KorailChip(
                text = "KTX 009",
                modifier = Modifier.clickable {
                    showBottomSheet = true
                }
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

            KorailBottomSheet(
                isOpenBottomSheet = showBottomSheet,
                sheetState = sheetState,
                title = "열차 조회",
                content = {
                    KorailOptionBottomSheetItem(
                        isActive = isItemEnabled,
                        activeBgColor = KorailTalkTheme.colors.purple05,
                        activeContentColor = KorailTalkTheme.colors.purple02,
                        onClick = {
                            isItemEnabled = !isItemEnabled
                        }
                    )
                },
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
package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    val sheetTrainState = rememberModalBottomSheetState()
    var showTrainBottomSheet by remember { mutableStateOf(false) }

    val sheetCardState = rememberModalBottomSheetState()
    var showCardBottomSheet by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            KorailChip(
                text = "KTX 009",
                modifier = Modifier.clickable {
                    showTrainBottomSheet = true
                }
            )
            KorailChip(
                text = "자주쓰는카드",
                modifier = Modifier.clickable {
                    showCardBottomSheet = true
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
                isOpenBottomSheet = showTrainBottomSheet,
                sheetState = sheetTrainState,
                title = "열차 조회",
                content = {
                    TrainSelectContent()
                }
            )

            KorailBottomSheet(
                isOpenBottomSheet = showCardBottomSheet,
                sheetState = sheetCardState,
                title = "자주쓰는카드",
                content = {
                    CardSelectContent()
                }
            )
        }
    }
}

@Composable
fun TrainSelectContent() {
    var activeIndex by remember { mutableIntStateOf(-1) }

    val options = listOf("모든열차", "KTX", "ITX", "무궁화")

    options.forEachIndexed { index, option ->
        KorailOptionBottomSheetItem(
            option = option,
            isActive = activeIndex == index,
            activeBgColor = KorailTalkTheme.colors.blue07,
            activeContentColor = KorailTalkTheme.colors.blue02,
            onClick = {
                activeIndex = if (activeIndex == index) -1 else index
            }
        )
    }
}

@Composable
fun CardSelectContent() {
    var activeIndex by remember { mutableIntStateOf(-1) }

    val options = listOf("직접입력", "내 현대카드")

    options.forEachIndexed { index, option ->
        KorailOptionBottomSheetItem(
            option = option,
            isActive = activeIndex == index,
            activeBgColor = KorailTalkTheme.colors.purple05,
            activeContentColor = KorailTalkTheme.colors.purple02,
            onClick = {
                activeIndex = if (activeIndex == index) -1 else index
            }
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
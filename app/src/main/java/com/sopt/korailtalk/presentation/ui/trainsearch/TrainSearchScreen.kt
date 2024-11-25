package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.data.remote.model.response.Timetable
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.KorailDoubleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.KorailWayInfo
import com.sopt.korailtalk.presentation.ui.SeatSelectContent
import com.sopt.korailtalk.presentation.ui.TrainSelectContent
import com.sopt.korailtalk.presentation.ui.WaySelectContent
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchDetailBottomSheet
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainFilter
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainInfoItem
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainSearchScreen() {

    var showTrainBottomSheet by remember { mutableStateOf(false) }
    var showSeatBottomSheet by remember { mutableStateOf(false) }
    var showWayBottomSheet by remember { mutableStateOf(false) }
    var isOpenBottomSheet by rememberSaveable { mutableStateOf(false) }

    val trainDummy = Timetable(
        timetableId = 1,
        trainName = "KTX 001",
        departureTime = "05:13",
        arrivalTime = "07:49",
        standardPrice = 12300,
        premiumPrice = 15000,
        isStandardSold = true,
        isPremiumSold = false,
        travelTime = 2,
    )
    val trainDummyList = mutableListOf<Timetable>()
    repeat(20) {
        trainDummyList.add(trainDummy)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            KorailDoubleActionTopAppBar(
                title = "열차 조회",
                backgroundColor = KorailTalkTheme.colors.blue01,
                primaryIconId = R.drawable.ic_topappbar_reload_24,
                secondaryIconId = R.drawable.ic_topappbar_menu_24
            )
            KorailWayInfo(
                departurePlace = "서울",
                arrivalPlace = "부산"
            )
            SearchTrainFilter(
                date = "2024.11.16 (토)",
                onTrainTypeClick = {
                    showTrainBottomSheet = true
                },
                onCarTypeClick = {
                    showSeatBottomSheet = true
                },
                onWayTypeClick = {
                    showWayBottomSheet = true
                }
            )
            LazyColumn {
                itemsIndexed(items = trainDummyList) { index, item ->
                    SearchTrainInfoItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        timetable = item,
                        onBasicCarClick = {
                            isOpenBottomSheet = true
                        },
                        onSpecialCarClick = {
                            isOpenBottomSheet = true
                        }
                    )
                    if (index < trainDummyList.lastIndex) {
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = KorailTalkTheme.colors.grey200
                        )
                    }
                }
            }
        }
    }

    KorailBottomSheet(
        isOpenBottomSheet = showTrainBottomSheet,
        sheetState = rememberModalBottomSheetState(),
        title = "열차선택",
        content = {
            TrainSelectContent()
        },
        onDismissRequest = {
            showTrainBottomSheet = false
        }
    )

    KorailBottomSheet(
        isOpenBottomSheet = showSeatBottomSheet,
        sheetState = rememberModalBottomSheetState(),
        title = "좌석형태",
        content = {
            SeatSelectContent()
        },
        onDismissRequest = {
            showSeatBottomSheet = false
        }
    )

    KorailBottomSheet(
        isOpenBottomSheet = showWayBottomSheet,
        sheetState = rememberModalBottomSheetState(),
        title = "열차유형",
        content = {
            WaySelectContent()
        },
        onDismissRequest = {
            showWayBottomSheet = false
        }
    )

    SearchDetailBottomSheet(
        isOpenBottomSheet = isOpenBottomSheet,
        date = "2024.11.16 (토)",
        trainData = trainDummy,
        onSelectSeatClick = {},
        onAutoSeatClick = {},
        onDismissRequest = {
            isOpenBottomSheet = false
        }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        TrainSearchScreen()
    }
}
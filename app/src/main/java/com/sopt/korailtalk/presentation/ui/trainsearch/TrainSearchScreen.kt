package com.sopt.korailtalk.presentation.ui.trainsearch

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.KorailDoubleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailWayInfo
import com.sopt.korailtalk.presentation.ui.SeatSelectContent
import com.sopt.korailtalk.presentation.ui.TrainSelectContent
import com.sopt.korailtalk.presentation.ui.WaySelectContent
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchDetailBottomSheet
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainDateChipGroup
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainFilter
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainInfoItem
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainSearchScreen(
    viewModel: TravelSearchViewModel = hiltViewModel(),
    navigateToSeatMap: () -> Unit,
    navigateToTrainCheck: () -> Unit,
) {
    val timeTableState by viewModel.timeTableState.collectAsState()

    var showDateChip by remember { mutableStateOf(false) }
    var showTrainBottomSheet by remember { mutableStateOf(false) }
    var showSeatBottomSheet by remember { mutableStateOf(false) }
    var showWayBottomSheet by remember { mutableStateOf(false) }
    var isOpenBottomSheet by rememberSaveable { mutableStateOf(false) }

    val selectedTime by viewModel.selectDate.collectAsState()
    val nextDay by viewModel.nextDate.collectAsState()
    val timeTableList by viewModel.timeTableList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getTimeTableData(
            userId = 1,
            date = "2024.11.16",
            departurePlace = "서울",
            arrivalPlace = "부산"
        )
    }

    when (val state = timeTableState) {
        is TimeTableState.Idle -> {
            Log.d("TrainSearchScreen", "Idle")
        }

        is TimeTableState.Loading -> {
            Log.d("TrainSearchScreen", "loading")
        }

        is TimeTableState.Success -> {
            Log.d("TrainSearchScreen", "${state.data}")
        }

        is TimeTableState.Failure -> {
            Log.d("TrainSearchScreen", "Failure")

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .background(color = KorailTalkTheme.colors.white),
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
                date = "2024.${selectedTime}",
                isPressed = showDateChip,
                onDateClick = {
                    showDateChip = !showDateChip
                },
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
            if (showDateChip) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = KorailTalkTheme.colors.grey100)
                        .padding(vertical = 7.dp)
                ) {
                    SearchTrainDateChipGroup(
                        chipList = viewModel.chipList,
                        selectedTime = selectedTime,
                        onActivedChange = { date ->
                            viewModel.setDate(date = date)
                        }
                    )
                }
            }

            LazyColumn {
                itemsIndexed(items = timeTableList) { index, item ->
                    SearchTrainInfoItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        timetable = item,
                        standardPrice = viewModel.formatPrice(item.standardPrice),
                        premiumPrice = viewModel.formatPrice(item.premiumPrice),
                        onBasicCarClick = {
                            isOpenBottomSheet = true
                        },
                        onSpecialCarClick = {
                            isOpenBottomSheet = true
                        }
                    )
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = KorailTalkTheme.colors.grey200
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(22.dp)
            )
            KorailRoundedButton(
                title = "다음날 (11월 ${nextDay}일) 조회하기",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                enabled = true,
                contentColor = KorailTalkTheme.colors.blue01,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.white,
                borderColor = KorailTalkTheme.colors.grey200,
                borderWidth = 1.dp,
                onClick = {
                    viewModel.setDate(date = "11.17 (일)")
                    viewModel.setNextDate()
                }
            )
            Spacer(
                modifier = Modifier
                    .height(58.dp)
            )
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
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
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
        trainData = viewModel.trainDummy,
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
        TrainSearchScreen(navigateToTrainCheck = {}, navigateToSeatMap = {})
    }
}
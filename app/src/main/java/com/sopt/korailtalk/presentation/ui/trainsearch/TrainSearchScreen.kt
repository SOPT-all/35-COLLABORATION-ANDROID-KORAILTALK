package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.KorailDoubleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.KorailWayInfo
import com.sopt.korailtalk.presentation.ui.TrainSelectContent
import com.sopt.korailtalk.presentation.ui.trainsearch.component.SearchTrainFilter
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainSearchScreen() {

    var showTrainBottomSheet by remember { mutableStateOf(false) }
    var showCarBottomSheet by remember { mutableStateOf(false) }
    var showWayBottomSheet by remember { mutableStateOf(false) }

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
                    showCarBottomSheet = true
                },
                onWayTypeClick = {
                    showWayBottomSheet = true
                }
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
        isOpenBottomSheet = showCarBottomSheet,
        sheetState = rememberModalBottomSheetState(),
        title = "좌석형태",
        content = {
            TrainSelectContent()
        },
        onDismissRequest = {
            showCarBottomSheet = false
        }
    )

    KorailBottomSheet(
        isOpenBottomSheet = showWayBottomSheet,
        sheetState = rememberModalBottomSheetState(),
        title = "열차유형",
        content = {
            TrainSelectContent()
        },
        onDismissRequest = {
            showWayBottomSheet = false
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
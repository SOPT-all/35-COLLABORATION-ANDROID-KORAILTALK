package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.ui.KorailChip
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

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState,
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp),
                    containerColor = KorailTalkTheme.colors.white,
                    contentColor = KorailTalkTheme.colors.blue02,
                    dragHandle = null
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Text(text = "This is the content of the Bottom Sheet.")
                        KorailOptionBottomSheetItem(
                            isActive = isItemEnabled,
                            activeBgColor = KorailTalkTheme.colors.purple05,
                            activeContentColor = KorailTalkTheme.colors.purple02,
                            onClick = {
                                isItemEnabled = !isItemEnabled
                            }
                        )
                    }
                }
            }
        }
    }


}

@Composable
private fun KorailOptionBottomSheetItem(
    isActive: Boolean,
    activeBgColor: Color,
    activeContentColor: Color,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isActive) activeBgColor else KorailTalkTheme.colors.white
            )
            .clickable {
                onClick()
            }
            .padding(vertical = 10.dp, horizontal = 22.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "모든열차",
            style = KorailTalkTheme.typography.title3.copy(
                color = if (isActive) activeContentColor else KorailTalkTheme.colors.black
            )
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        if (isActive) {
            Image(
                painter = painterResource(R.drawable.icn_check),
                colorFilter = ColorFilter.tint(
                    color = activeContentColor
                ),
                contentDescription = "체크"
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
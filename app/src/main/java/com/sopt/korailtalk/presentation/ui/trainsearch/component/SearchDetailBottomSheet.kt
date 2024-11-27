package com.sopt.korailtalk.presentation.ui.trainsearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.domain.model.TrainInformation
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.KorailChip
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SearchDetailBottomSheet(
    isOpenBottomSheet: Boolean,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    date: String,
    trainData: TrainInformation,
    onSelectSeatClick: () -> Unit,
    onAutoSeatClick: () -> Unit,
    onDismissRequest: () -> Unit = {},
) {
    var isTimeTableVisible by remember { mutableStateOf(false) }
    var isMoneyTableVisible by remember { mutableStateOf(false) }

    KorailBottomSheet(
        isOpenBottomSheet = isOpenBottomSheet,
        sheetState = sheetState,
        title = "기차 상세",
        content = {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = KorailTalkTheme.colors.blue07)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = date,
                    style = KorailTalkTheme.typography.title3.copy(
                        KorailTalkTheme.colors.black
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                KorailChip(
                    text = trainData.trainName
                )
            }
            SearchWayInfoWithTravelTime(
                departureTime = trainData.departureTime,
                arrivalTime = trainData.arrivalTime,
                travelTime = trainData.travelTime,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SearchTrainInfoDropDown(
                    modifier = Modifier
                        .fillMaxWidth(),
                    title = "시간표",
                    iconId = R.drawable.ic_search_timetable,
                    imageId = R.drawable.img_search_timetable,
                    onClick = {
                        isTimeTableVisible = !isTimeTableVisible
                        isMoneyTableVisible = false
                    },
                    isActive = isTimeTableVisible
                )
                SearchTrainInfoDropDown(
                    modifier = Modifier
                        .fillMaxWidth(),
                    title = "운임요금",
                    iconId = R.drawable.ic_search_money,
                    imageId = R.drawable.img_search_moneytable,
                    onClick = {
                        isMoneyTableVisible = !isMoneyTableVisible
                        isTimeTableVisible = false
                    },
                    isActive = isMoneyTableVisible
                )
            }
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                KorailRoundedButton(
                    title = "좌석 선택",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                        .weight(1f),
                    enabled = true,
                    contentColor = KorailTalkTheme.colors.blue01,
                    cornerRadius = 26.dp,
                    backgroundColor = KorailTalkTheme.colors.white,
                    borderColor = KorailTalkTheme.colors.grey200,
                    borderWidth = 1.dp,
                    onClick = onSelectSeatClick
                )
                Spacer(modifier = Modifier.width(8.dp))
                KorailRoundedButton(
                    title = "자동 배정",
                    modifier = Modifier
                        .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                        .weight(1f),
                    enabled = true,
                    contentColor = KorailTalkTheme.colors.white,
                    cornerRadius = 26.dp,
                    backgroundColor = KorailTalkTheme.colors.blue03,
                    onClick = onAutoSeatClick
                )
            }
            Spacer(modifier = Modifier.height(42.dp))
        },
        onDismissRequest = onDismissRequest
    )
}

@Composable
private fun SearchTrainInfoDropDown(
    title: String,
    iconId: Int,
    imageId: Int,
    onClick: () -> Unit,
    isActive: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .roundedBackgroundWithBorder(
                    cornerRadius = 8.dp,
                    backgroundColor = KorailTalkTheme.colors.white,
                    borderColor = KorailTalkTheme.colors.grey200,
                    borderWidth = 1.dp
                )
                .clickableWithoutRipple {
                    onClick()
                }
                .padding(
                    horizontal = 16.dp, vertical = 12.dp
                ),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(iconId),
                contentDescription = title
            )
            Spacer(
                modifier = Modifier
                    .width(6.dp)
            )
            Text(
                text = title,
                color = KorailTalkTheme.colors.black,
                style = KorailTalkTheme.typography.body2
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            if (isActive) {
                Image(
                    painter = painterResource(R.drawable.ic_search_arrow_up),
                    contentDescription = null
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(R.drawable.ic_search_arrow_down),
                    contentDescription = null
                )
            }
        }
        if (isActive) {
            Image(
                painter = painterResource(imageId),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-6).dp),
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ShowSearchDetailBottomSheet() {
    var isOpenBottomSheet by rememberSaveable { mutableStateOf(false) }
    val trainDummy = TrainInformation(
        timetableId = 1,
        trainName = "KTX 001",
        departureTime = "05:13",
        arrivalTime = "07:49",
        standardPrice = 10000,
        premiumPrice = 15000,
        isStandardSold = true,
        isPremiumSold = false,
        travelTime = 2,
    )

    KorailChip(
        text = "SearchDetailBottomSheet",
        modifier = Modifier
            .clickableWithoutRipple {
                isOpenBottomSheet = true
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
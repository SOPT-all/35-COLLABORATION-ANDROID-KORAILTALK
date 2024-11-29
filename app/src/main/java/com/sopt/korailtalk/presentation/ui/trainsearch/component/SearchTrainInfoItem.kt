package com.sopt.korailtalk.presentation.ui.trainsearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.domain.model.TimeTable
import com.sopt.korailtalk.domain.type.CarType
import com.sopt.korailtalk.domain.type.SearchTrainStateType
import com.sopt.korailtalk.presentation.ui.KorailChip
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun SearchTrainInfoItem(
    timetable: TimeTable,
    standardPrice: String?,
    premiumPrice: String?,
    modifier: Modifier = Modifier,
    onBasicCarClick: () -> Unit = {},
    onSpecialCarClick: () -> Unit = {}
) {
    var basicCarState by remember { mutableStateOf(SearchTrainStateType.SALE) }

    Row(
        modifier = modifier
            .background(color = KorailTalkTheme.colors.white)
            .padding(horizontal = 16.dp, vertical = 18.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            KorailChip(
                text = timetable.trainName
            )
            Spacer(
                modifier = Modifier
                    .height(11.dp)
            )
            SearchDepartureToArrival(
                departureTime = timetable.departureTime,
                arrivalTime = timetable.arrivalTime,
            )
        }
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        SearchTrainSelectButton(
            trainType = CarType.BASIC.text,
            trainCost = standardPrice,
            state = basicCarState,
            onButtonClick = {
                basicCarState = SearchTrainStateType.ACTIVE
                onBasicCarClick()
            }
        )
        Spacer(
            modifier = Modifier
                .width(12.dp)
        )
        if (timetable.isPremiumSold) {
            SearchTrainSelectButton(
                trainType = CarType.SPECIAL.text,
                trainCost = premiumPrice,
                state = if (timetable.isPremiumSold) SearchTrainStateType.SALE else SearchTrainStateType.SOLD_OUT,
                onButtonClick = onSpecialCarClick
            )
        } else {
            Image(
                painter = painterResource(R.drawable.ic_search_soldout),
                contentDescription = "매진",
                modifier = Modifier
                    .width((LocalConfiguration.current.screenWidthDp * 0.214).dp),
                contentScale = ContentScale.FillWidth
            )
        }

    }
}

@Composable
private fun SearchTrainSelectButton(
    trainType: String,
    trainCost: String?,
    state: SearchTrainStateType,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 12.dp,
                backgroundColor = when (state) {
                    SearchTrainStateType.SALE -> KorailTalkTheme.colors.white // 판매 중
                    SearchTrainStateType.SOLD_OUT -> KorailTalkTheme.colors.grey300 // 매진
                    SearchTrainStateType.ACTIVE -> KorailTalkTheme.colors.blue06 // 활성화 상태
                },
                borderColor = when (state) {
                    SearchTrainStateType.SALE -> KorailTalkTheme.colors.blue02 // 판매 중
                    SearchTrainStateType.SOLD_OUT -> KorailTalkTheme.colors.grey400 // 매진
                    SearchTrainStateType.ACTIVE -> KorailTalkTheme.colors.blue02 // 활성화 상태
                },
                borderWidth = 1.dp
            )
            .clickableWithoutRipple {
                onButtonClick()
            }
            .padding(horizontal = 9.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = trainType,
                color = when (state) {
                    SearchTrainStateType.SALE -> KorailTalkTheme.colors.blue02 // 판매 중
                    SearchTrainStateType.SOLD_OUT -> KorailTalkTheme.colors.grey400 // 매진
                    SearchTrainStateType.ACTIVE -> KorailTalkTheme.colors.blue02 // 활성화 상태
                },
                style = KorailTalkTheme.typography.caption2
            )
            Text(
                text = "${trainCost}원",
                color = when (state) {
                    SearchTrainStateType.SALE -> KorailTalkTheme.colors.black // 판매 중
                    SearchTrainStateType.SOLD_OUT -> KorailTalkTheme.colors.grey400 // 매진
                    SearchTrainStateType.ACTIVE -> KorailTalkTheme.colors.black // 활성화 상태
                },
                style = KorailTalkTheme.typography.body2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowSearchTrainInfoItem() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = KorailTalkTheme.colors.grey500)
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            val trainDummy = TimeTable(
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
            val trainDummy2 = TimeTable(
                timetableId = 1,
                trainName = "KTX 001",
                departureTime = "05:13",
                arrivalTime = "07:49",
                standardPrice = 10000,
                premiumPrice = 23489,
                isStandardSold = true,
                isPremiumSold = true,
                travelTime = 2,
            )

            SearchTrainInfoItem(
                modifier = Modifier
                    .fillMaxWidth(),
                timetable = trainDummy,
                standardPrice = "",
                premiumPrice = ""
            )
            SearchTrainInfoItem(
                timetable = trainDummy2,
                modifier = Modifier
                    .fillMaxWidth(),
                standardPrice = "",
                premiumPrice = ""
            )
        }
    }

}
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun SearchWayInfoWithTravelTime(
    departureTime: String,
    arrivalTime: String,
    travelTime: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 39.dp)
    ) {
        SearchWayInfoItem(
            location = "서울",
            time = departureTime
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.icn_trainsearch_arrow_blue_right),
                contentDescription = "화살표"
            )
            Text(
                text = travelTime.toString(),
                style = KorailTalkTheme.typography.caption4.copy(
                    color = KorailTalkTheme.colors.grey500
                )
            )
        }
        SearchWayInfoItem(
            location = "부산",
            time = arrivalTime
        )
    }
}

@Composable
fun SearchWayInfoItem(
    location: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = location,
            style = KorailTalkTheme.typography.head5.copy(
                color = KorailTalkTheme.colors.black
            )
        )
        Text(
            text = time,
            style = KorailTalkTheme.typography.body3.copy(
                color = KorailTalkTheme.colors.black
            )
        )
    }
}

@Composable
fun SearchTrainDateChipGroup(
    chipList: List<String>,
    modifier: Modifier = Modifier
) {
    var selectedTime by remember { mutableStateOf<String?>(null) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        chipList.forEach { chipTime ->
            SearchTrainDateChip(
                date = chipTime,
                isSelected = selectedTime == chipTime,
                onSelectedChange = {
                    selectedTime = if (selectedTime == chipTime) null else chipTime
                }
            )
        }
    }
}

@Composable
fun SearchTrainDateChip(
    date: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onSelectedChange: (Boolean) -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = if (isSelected) KorailTalkTheme.colors.blue04 else KorailTalkTheme.colors.grey25,
                shape = RoundedCornerShape(size = 17.dp)
            )
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable {
                onSelectedChange(isSelected)
            }
    ) {
        Text(
            text = date,
            style = KorailTalkTheme.typography.body3.copy(
                color = if (isSelected) KorailTalkTheme.colors.white else KorailTalkTheme.colors.grey500
            )
        )
    }
}

@Composable
fun SearchTrainFilter(
    date: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = KorailTalkTheme.colors.blue07)
            .padding(start = 16.dp, end = 10.dp, top = 12.dp, bottom = 12.dp)
    ) {
        Text(
            text = date,
            style = KorailTalkTheme.typography.title3.copy(
                KorailTalkTheme.colors.black
            )
        )
        Image(
            painter = painterResource(R.drawable.icn_search_arrow_down),
            contentDescription = "화살표"
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        ) {
            SearchFilterItem(
                filterName = "모든 열차"
            )
            SearchFilterItem(
                filterName = "일반석"
            )
            SearchFilterItem(
                filterName = "직통"
            )
        }

    }
}

@Composable
fun SearchFilterItem(
    filterName: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = filterName,
            style = KorailTalkTheme.typography.body2.copy(
                color = KorailTalkTheme.colors.grey500
            )
        )
        Image(
            painter = painterResource(R.drawable.icn_trainsearch_arrow_down),
            contentDescription = "화살표"
        )
    }
}

@Composable
fun SearchDepartureToArrival(
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
package com.sopt.korailtalk.presentation.ui.seatmap

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.sopt.korailtalk.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.korailtalk.presentation.ui.KorailDoubleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailWayInfo
import com.sopt.korailtalk.presentation.ui.seatmap.component.SeatMapCoachSelector
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun SeatMapScreen(
    departPlace: String,
    arrivalPlace: String,
    viewModel: SeatMapViewModel = viewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(KorailTalkTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        KorailDoubleActionTopAppBar(
            title = "좌석 선택",
            backgroundColor = KorailTalkTheme.colors.blue01,
            primaryIconId = R.drawable.ic_topappbar_reload_24,
            secondaryIconId = R.drawable.ic_topappbar_menu_24,
        )

        KorailWayInfo(departPlace, arrivalPlace)

        Text(
            text = "2024.11.16 (토)",
            modifier = Modifier.fillMaxWidth()
                .background(color = KorailTalkTheme.colors.blue07)
                .padding(vertical = 10.dp),
            style = KorailTalkTheme.typography.title3,
            textAlign = TextAlign.Center
        )

        LazyRow(
            modifier = Modifier
                .background(KorailTalkTheme.colors.grey100)
                .padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            items(viewModel.seatsMapData.size) { index ->
                val coach = viewModel.seatsMapData[index]
                SeatMapCoachSelector(
                    coachId = coach.coachId,
                    leftSeats = coach.seats.size,
                    isSelected = coach.coachId == viewModel.selectedCoachId.value,
                    onSelectionChange = viewModel::selectCoach
                )
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .weight(1f)
            .verticalScroll(rememberScrollState())) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Pillar() // 왼쪽 기둥
                Seats(viewModel.selectedCoachId,
                    modifier = Modifier.weight(1f))  // 좌석 영역
                Pillar() // 오른쪽 기둥
            }
        }

        Column(modifier = Modifier.fillMaxWidth()
            .aspectRatio(360/175f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally){
            Row (modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
            ){
                Text(text = "좌석을 선택해주세요",
                    color = KorailTalkTheme.colors.black,
                    style = KorailTalkTheme.typography.title1)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "0",
                    color = KorailTalkTheme.colors.black,
                    style = KorailTalkTheme.typography.head5)
                Text(text = "/1",
                    color = KorailTalkTheme.colors.black,
                    style = KorailTalkTheme.typography.title3,
                    modifier = Modifier.align(Alignment.Bottom))
            }

            KorailRoundedButton(
                title = "선택 완료",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                enabled = false,
                contentColor = KorailTalkTheme.colors.white,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.blue03,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun Seats(selectedCoachId: MutableState<Long?>, modifier: Modifier) {
    Column(modifier = modifier){
        repeat(50) { index ->
            Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                // 이 text가 컴포넌트화 될 Seat 입니다!
                Text(text = "${index + 1}A", modifier = Modifier.padding(8.dp))
                Text(text = "${index + 1}B", modifier = Modifier.padding(8.dp))
                Image(painter = painterResource(R.drawable.ic_seat_direction),
                    contentDescription = "열차 운행 방향")
                Text(text = "${index + 1}C", modifier = Modifier.padding(8.dp))
                Text(text = "${index + 1}D", modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun Pillar() {
    Column(modifier = Modifier.width(8.dp)) {
        Box(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .background(KorailTalkTheme.colors.blue06)
        )

        repeat(5) {
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .height(92.dp)
                    .fillMaxWidth()
                    .background(KorailTalkTheme.colors.blue06)
            )
        }
    }
}

@Preview
@Composable
fun SeatMapScreenPreview(){
    SeatMapScreen("서울", "부산")
}


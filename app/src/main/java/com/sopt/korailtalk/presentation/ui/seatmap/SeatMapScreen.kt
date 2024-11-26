package com.sopt.korailtalk.presentation.ui.seatmap

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import com.sopt.korailtalk.presentation.ui.KorailDialog
import com.sopt.korailtalk.presentation.ui.KorailDoubleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailWayInfo
import com.sopt.korailtalk.presentation.ui.seatmap.component.SeatMapCoachSelector
import com.sopt.korailtalk.presentation.ui.seatmap.component.SeatMapSeatSelector
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
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
                    leftSeats = coach.leftSeats,
                    isSelected = coach.coachId == viewModel.selectedCoachId.value,
                    onSelectionChange = viewModel::selectCoach
                )
            }
        }

        Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)){
            Column(
                modifier = Modifier.padding(end = 12.dp)
            ) {
                Row {
                    Image(painter = painterResource(R.drawable.ic_seatmap_forward),
                        contentDescription = "순방향 이미지",
                        modifier = Modifier.padding(end = 3.dp))
                    Text(text = "선택가능 (순방향)",
                        color = KorailTalkTheme.colors.grey600,
                        style = KorailTalkTheme.typography.caption2)
                }
                Row {
                    Image(painter = painterResource(R.drawable.ic_seatmap_backward),
                        contentDescription = "역방향 이미지",
                        modifier = Modifier.padding(end = 3.dp))
                    Text(text = "선택가능 (역방향)",
                        color = KorailTalkTheme.colors.grey600,
                        style = KorailTalkTheme.typography.caption2)
                }
            }
            Row {
                Image(painter = painterResource(R.drawable.ic_seatmap_none),
                    contentDescription = "선택불가 이미지",
                    modifier = Modifier.padding(end = 3.dp))
                Text(text = "선택불가",
                    color = KorailTalkTheme.colors.grey600,
                    style = KorailTalkTheme.typography.caption2)
            }
            Spacer(modifier = Modifier.weight(1f))
            Row (
                modifier = Modifier
                    .roundedBackgroundWithBorder(14.dp, KorailTalkTheme.colors.white,
                        KorailTalkTheme.colors.grey300, 2.dp)
                    .padding(vertical = 6.dp, horizontal = 8.dp)
            ){
                Image(painter = painterResource(R.drawable.ic_seatmap_consent),
                    contentDescription = "콘센트 이미지")
                Text(text = "콘센트 확인",
                    color = KorailTalkTheme.colors.blue01,
                    style = KorailTalkTheme.typography.caption1)
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
                Seats(selectedCoachId = viewModel.selectedCoachId,
                    viewModel = viewModel,
                    modifier = Modifier.weight(1f)) // 좌석 영역
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
fun Seats(selectedCoachId: MutableState<Long?>, viewModel: SeatMapViewModel, modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        viewModel.seatsMapData.find { it.coachId == selectedCoachId.value }?.seats?.reversed()?.let { seats ->
            seats.chunked(4).forEach { rowSeats ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,  // 좌석 사이에 공간을 균등하게 배분
                    modifier = Modifier.fillMaxWidth()
                ) {
                    rowSeats.forEachIndexed { index, seat ->
                        SeatMapSeatSelector(
                            seatId = seat.seatId,
                            seatName = seat.seatName,
                            direction = seat.direction,
                            isSold = seat.isSold,
                            isSelected = viewModel.selectedSeatId.value == seat.seatId,
                            onSelectionChange = { id ->
                                viewModel.selectSeat(id)
                            }
                        )

                        if (index == 1) {  // 첫 번째와 두 번째 좌석 사이
                            Image(
                                painter = painterResource(id = R.drawable.ic_seat_direction),
                                contentDescription = "열차 진행 방향",
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )
                        }
                    }
                }
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
                .clip(shape = RoundedCornerShape(4.dp))
                .background(KorailTalkTheme.colors.blue06)
        )

        repeat(6) {
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .height(92.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
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


package com.sopt.korailtalk.presentation.ui.seatmap

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "상단 바",
            modifier = Modifier.fillMaxWidth()
                .background(KorailTalkTheme.colors.blue01)
                .aspectRatio(360f / 55f))

        KorailWayInfo(departPlace, arrivalPlace)

        LazyRow {
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
            .aspectRatio(360/251f)
            .verticalScroll(rememberScrollState())) {
            Row {
                Pillar() // 왼쪽 기둥
                Seats(viewModel.selectedCoachId)  // 좌석 영역
                Pillar() // 오른쪽 기둥
            }
        }
    }
}

@Composable
fun Seats(selectedCoachId: MutableState<Long?>) {
    Column {
        repeat(50) { index ->
            Row(modifier = Modifier.padding(8.dp)) {
                // 이 text가 컴포넌트화 될 Seat 입니다!
                Text(text = "${index + 1}A", modifier = Modifier.padding(8.dp))
                Text(text = "${index + 1}B", modifier = Modifier.padding(8.dp))
                Text(text = "${index + 1}C", modifier = Modifier.padding(8.dp))
                Text(text = "${index + 1}D", modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun Pillar() {
    Column(modifier = Modifier.width(50.dp)) {
        // 임의로 Box로 표현했습니다.
        Box(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .background(KorailTalkTheme.colors.blue06)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .height(92.dp)
                .fillMaxWidth()
                .background(KorailTalkTheme.colors.blue06)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Box(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .background(KorailTalkTheme.colors.blue06)
        )
    }
}

@Preview
@Composable
fun SeatMapScreenPreview(){
    SeatMapScreen("서울", "부산")
}


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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.sopt.korailtalk.presentation.ui.KorailDialog
import com.sopt.korailtalk.presentation.ui.KorailDoubleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.KorailWayInfo
import com.sopt.korailtalk.presentation.ui.seatmap.component.SeatMapCoachSelector
import com.sopt.korailtalk.presentation.ui.seatmap.component.SeatMapSeatSelector
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography

@Composable
fun SeatMapScreen(
    departPlace: String,
    arrivalPlace: String,
) {
    val viewModel: SeatMapViewModel = viewModel()
    val showDialog = viewModel.showDialog

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KorailTalkTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        KorailDoubleActionTopAppBar(
            title = stringResource(R.string.seatMap_title),
            backgroundColor = KorailTalkTheme.colors.blue01,
            primaryIconId = R.drawable.ic_topappbar_reload_24,
            secondaryIconId = R.drawable.ic_topappbar_menu_24,
        )

        KorailWayInfo(departPlace, arrivalPlace)

        Text(
            text = stringResource(R.string.seatMap_date),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = KorailTalkTheme.colors.blue07)
                .padding(vertical = 10.dp),
            style = typography.title3,
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
                Row(
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Image(painter = painterResource(R.drawable.ic_seatmap_forward),
                        contentDescription = "순방향 이미지",
                        modifier = Modifier.padding(end = 3.dp))
                    Text(text = stringResource(R.string.seatMap_forward_active),
                        color = KorailTalkTheme.colors.grey600,
                        style = typography.caption2)
                }
                Row {
                    Image(painter = painterResource(R.drawable.ic_seatmap_backward),
                        contentDescription = "역방향 이미지",
                        modifier = Modifier.padding(end = 3.dp))
                    Text(text = stringResource(R.string.seatMap_backward_actvie),
                        color = KorailTalkTheme.colors.grey600,
                        style = typography.caption2)
                }
            }
            Row {
                Image(painter = painterResource(R.drawable.ic_seatmap_none),
                    contentDescription = "선택불가 이미지",
                    modifier = Modifier.padding(end = 3.dp))
                Text(text = stringResource(R.string.seatMap_inactive),
                    color = KorailTalkTheme.colors.grey600,
                    style = typography.caption2)
            }
            Spacer(modifier = Modifier.weight(1f))
            Row (
                modifier = Modifier
                    .roundedBackgroundWithBorder(
                        14.dp, KorailTalkTheme.colors.white,
                        KorailTalkTheme.colors.grey200, 2.dp
                    )
                    .padding(vertical = 6.dp, horizontal = 8.dp)
                    .padding(end = 4.dp)
                    .clickableWithoutRipple(onClick = { viewModel.toggleDialog(true) })
            ){
                Image(painter = painterResource(R.drawable.ic_seatmap_consent),
                    contentDescription = "콘센트 이미지")
                Text(text = stringResource(R.string.korailDialog_consentTitle),
                    color = KorailTalkTheme.colors.blue01,
                    style = typography.caption1)
            }

        }

        if (showDialog.value) {
            KorailDialog(
                title = stringResource(R.string.korailDialog_consentTitle),
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(KorailTalkTheme.colors.white)
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.korailDialog_consentDescription),
                                style = typography.caption2,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.img_outlet),
                                contentDescription = stringResource(R.string.seatmap_consent_description),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.23f)
                            )
                        }
                    }
                },
                onConfirm = { viewModel.toggleDialog(false) })
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

        Column(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(360 / 175f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally){
            Row (modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
            ){
                Text(text = stringResource(R.string.seatMap_choose),
                    color = KorailTalkTheme.colors.black,
                    style = typography.title1)
                Spacer(modifier = Modifier.weight(1f))
                // selectedSeatId가 있으면 0, 없으면 1로 출력
                Text(text = if(viewModel.selectedSeatId.value == null) "0" else "1",
                    color = KorailTalkTheme.colors.black,
                    style = typography.head5)
                Text(text = "/1",
                    color = KorailTalkTheme.colors.black,
                    style = typography.title3,
                    modifier = Modifier.align(Alignment.Bottom))
            }

            KorailRoundedButton(
                title = "선택 완료",
                modifier = Modifier
                    .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                enabled = viewModel.selectedSeatId.value != null,
                contentColor = KorailTalkTheme.colors.white,
                cornerRadius = 26.dp,
                backgroundColor = KorailTalkTheme.colors.blue03,
                onClick = { } // 승차권 확인으로 이동합니다.
            )
            Spacer(modifier = Modifier.weight(1f))
            }
        }

}

@Composable
fun Seats(selectedCoachId: MutableState<Long?>, viewModel: SeatMapViewModel, modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        // 해당 coachId의 seats 데이터를 호출, 15부터 위에서 아래로 출력
        viewModel.seatsMapData.find { it.coachId == selectedCoachId.value }?.seats?.reversed()?.let { seats ->
            // 한 줄의 4개씩 배치
            seats.chunked(4).forEach { rowSeats ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp)
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

                        if (index == 1) {  // 좌석 2와 3 사이
                            Image(
                                painter = painterResource(id = R.drawable.ic_seat_direction),
                                contentDescription = "열차 진행 방향",
                                modifier = Modifier.padding(horizontal = 10.dp)
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(60.dp))
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


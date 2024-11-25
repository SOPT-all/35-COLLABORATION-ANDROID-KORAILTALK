package com.sopt.korailtalk.presentation.ui.seatmap.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography

@Composable
fun SeatMapCoachSelector(
    coachId: Long,
    leftSeats: Int,
    isSelected: Boolean,
    onSelectionChange: (Long) -> Unit
) {
    val backgroundColor = if (isSelected) KorailTalkTheme.colors.blue06 else KorailTalkTheme.colors.white
    val borderColor = if (isSelected) KorailTalkTheme.colors.blue02 else KorailTalkTheme.colors.grey300

    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clickable(
                enabled = true,
                onClick = {
                    if (!isSelected) {
                        onSelectionChange(coachId)
                    }
                })
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = backgroundColor,
                borderColor = borderColor,
                borderWidth = 1.dp
            )
            .padding(horizontal = 21.5.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = stringResource(R.string.seatMapCoachSelector_coach, coachId),
            style = typography.caption1,
            modifier = Modifier.padding(bottom = 6.dp))
        Text(text = stringResource(R.string.seatMapCoachSelectpr_normal),
            style = typography.caption2,
            modifier = Modifier.padding(bottom = 6.dp))
        Text(text = stringResource(R.string.seatMapCoachSelector_leftSeats, leftSeats),
            style = typography.body2)
    }
}

@Preview
@Composable
fun SeatMapCoachSelectorPreview(){
    // 임의로 1호차 선택
    var selectedCoachId by remember { mutableStateOf(1L) }
    SeatMapCoachSelector(1, 49, selectedCoachId.toInt() == 1) { newCoachId ->
        // 새로운 호차 선택 시 해당 호차 선택 제거
        if (selectedCoachId != newCoachId) {
            selectedCoachId = newCoachId
        }
    }
}
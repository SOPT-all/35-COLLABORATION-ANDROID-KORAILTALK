package com.sopt.korailtalk.presentation.ui.seatmap.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.LocalColors

@Composable
fun SeatMapSeatSelector(
    seatId: Long,
    seatName: String,
    direction: Boolean,
    isSold: Boolean,
    isSelected: Boolean,
    onSelectionChange: (Long?) -> Unit
) {
    val image = when {
        isSold -> if (direction) R.drawable.icn_seatmap_forward_inactive else R.drawable.icn_seatmap_backward_inactive
        isSelected -> if (direction) R.drawable.icn_seatmap_forward_selected else R.drawable.icn_seatmap_backward_selected
        else -> if (direction) R.drawable.icn_seatmap_forward_activate else R.drawable.icn_seatmap_backward_activate
    }
    val textColor = if (isSelected) LocalColors.current.white else LocalColors.current.black

    Box(
        modifier = Modifier
            .clickable(enabled = !isSold) {
                onSelectionChange(if (isSelected) null else seatId)
            }
    ){
        Image(painter = painterResource(id = image),
            contentDescription = "좌석 이미지")
        Text(text = seatName,
            color = textColor,
            modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun SeatMapSeatSelectorPreview() {
    // 클릭 시 해당 좌석 아이디를 반환, 아무 좌석이 선택 안된 경우는 null
    var selectedSeatId by remember { mutableStateOf<Long?>(null) }
    SeatMapSeatSelector(
        seatId = 1,
        seatName = "1A",
        direction = false,
        isSold = false,
        isSelected = selectedSeatId?.toInt() == 1,
        onSelectionChange = { newSeatId ->
            selectedSeatId = newSeatId
        }
    )
}
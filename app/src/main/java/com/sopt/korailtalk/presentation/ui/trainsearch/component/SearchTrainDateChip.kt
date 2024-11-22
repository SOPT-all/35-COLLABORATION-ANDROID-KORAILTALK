package com.sopt.korailtalk.presentation.ui.trainsearch.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

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
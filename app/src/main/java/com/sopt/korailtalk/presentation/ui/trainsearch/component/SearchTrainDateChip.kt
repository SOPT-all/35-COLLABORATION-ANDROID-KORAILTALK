package com.sopt.korailtalk.presentation.ui.trainsearch.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun SearchTrainDateChip(
    date: String,
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    onSelectedChange: (Boolean) -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = if (isActive) KorailTalkTheme.colors.blue04 else KorailTalkTheme.colors.grey25,
                shape = RoundedCornerShape(size = 17.dp)
            )
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickableWithoutRipple {
                onSelectedChange(isActive)
            }
    ) {
        Text(
            text = date,
            style = KorailTalkTheme.typography.body3.copy(
                color = if (isActive) KorailTalkTheme.colors.white else KorailTalkTheme.colors.grey500
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

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(items = chipList) { chipTime ->
            SearchTrainDateChip(
                date = chipTime,
                isActive = selectedTime == chipTime,
                onSelectedChange = {
                    selectedTime = if (selectedTime == chipTime) null else chipTime
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowSearchTrainDateChip() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = KorailTalkTheme.colors.grey500)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            val chipList = listOf("11:08", "11:18", "11:28", "11:38")

            SearchTrainDateChipGroup(
                chipList = chipList
            )
        }
    }
}
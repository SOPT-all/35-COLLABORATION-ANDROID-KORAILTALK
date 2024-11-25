package com.sopt.korailtalk.presentation.ui.trainsearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun SearchTrainFilter(
    date: String,
    isPressed: Boolean,
    modifier: Modifier = Modifier,
    onDateClick: () -> Unit = {},
    onTrainTypeClick: () -> Unit = {},
    onCarTypeClick: () -> Unit = {},
    onWayTypeClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = KorailTalkTheme.colors.blue07)
            .padding(start = 16.dp, end = 10.dp, top = 12.dp, bottom = 12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickableWithoutRipple {
                    onDateClick()
                }
        ) {
            Text(
                text = date,
                style = KorailTalkTheme.typography.title3.copy(
                    KorailTalkTheme.colors.black
                )
            )
            if (isPressed) {
                Image(
                    painter = painterResource(R.drawable.ic_search_triangle_up),
                    contentDescription = null
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.ic_search_triangle_down),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        ) {
            SearchFilterItem(
                filterName = "모든 열차",
                onFilterClick = onTrainTypeClick
            )
            SearchFilterItem(
                filterName = "일반석",
                onFilterClick = onCarTypeClick
            )
            SearchFilterItem(
                filterName = "직통",
                onFilterClick = onWayTypeClick
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowSearchTrainFilter() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            SearchTrainFilter(
                date = "2024.11.16 (토)",
                isPressed = false
            )
        }
    }
}
package com.sopt.korailtalk.presentation.ui.trainsearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

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
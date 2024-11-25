package com.sopt.korailtalk.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.domain.type.SearchCarType
import com.sopt.korailtalk.domain.type.SearchTrainType
import com.sopt.korailtalk.domain.type.SearchWayType
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun KorailOptionBottomSheetItem(
    option: String,
    isActive: Boolean,
    activeBgColor: Color,
    activeContentColor: Color,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height((LocalConfiguration.current.screenHeightDp * 0.072).dp)
            .background(
                color = if (isActive) activeBgColor else KorailTalkTheme.colors.white
            )
            .clickableWithoutRipple {
                onClick()
            }
            .padding(vertical = 10.dp, horizontal = 22.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = option,
            style = KorailTalkTheme.typography.title3.copy(
                color = if (isActive) activeContentColor else KorailTalkTheme.colors.black
            )
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        if (isActive) {
            Image(
                painter = painterResource(R.drawable.ic_check),
                colorFilter = ColorFilter.tint(
                    color = activeContentColor
                ),
                contentDescription = null
            )
        }
    }
}

@Composable
fun TrainSelectContent() {
    var activeIndex by remember { mutableIntStateOf(-1) }

    val options = SearchTrainType.entries.toTypedArray()

    options.forEachIndexed { index, option ->
        KorailOptionBottomSheetItem(
            option = option.text,
            isActive = activeIndex == index,
            activeBgColor = KorailTalkTheme.colors.blue07,
            activeContentColor = KorailTalkTheme.colors.blue02,
            onClick = {
                activeIndex = if (activeIndex == index) -1 else index
            }
        )
    }
}

@Composable
fun SeatSelectContent() {
    var activeIndex by remember { mutableIntStateOf(-1) }

    val options = SearchCarType.entries.toTypedArray()

    options.forEachIndexed { index, option ->
        KorailOptionBottomSheetItem(
            option = option.text,
            isActive = activeIndex == index,
            activeBgColor = KorailTalkTheme.colors.blue07,
            activeContentColor = KorailTalkTheme.colors.blue02,
            onClick = {
                activeIndex = if (activeIndex == index) -1 else index
            }
        )
    }
}

@Composable
fun WaySelectContent() {
    var activeIndex by remember { mutableIntStateOf(-1) }

    val options = SearchWayType.entries.toTypedArray()

    options.forEachIndexed { index, option ->
        KorailOptionBottomSheetItem(
            option = option.text,
            isActive = activeIndex == index,
            activeBgColor = KorailTalkTheme.colors.blue07,
            activeContentColor = KorailTalkTheme.colors.blue02,
            onClick = {
                activeIndex = if (activeIndex == index) -1 else index
            }
        )
    }
}

@Composable
fun CardSelectContent() {
    var activeIndex by remember { mutableIntStateOf(-1) }

    val options = listOf("직접입력", "내 현대카드")

    options.forEachIndexed { index, option ->
        KorailOptionBottomSheetItem(
            option = option,
            isActive = activeIndex == index,
            activeBgColor = KorailTalkTheme.colors.purple05,
            activeContentColor = KorailTalkTheme.colors.purple02,
            onClick = {
                activeIndex = if (activeIndex == index) -1 else index
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ShowKorailOptionBottomSheetItem() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            TrainSelectContent()
            CardSelectContent()
        }
    }
}
package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.presentation.ui.CardSelectContent
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.KorailChip
import com.sopt.korailtalk.presentation.ui.TrainSelectContent
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainSearchScreen() {

    val sheetTrainState = rememberModalBottomSheetState()
    var showTrainBottomSheet by remember { mutableStateOf(false) }

    val sheetCardState = rememberModalBottomSheetState()
    var showCardBottomSheet by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            KorailChip(
                text = "KTX 009",
                modifier = Modifier.clickableWithoutRipple {
                    showTrainBottomSheet = true
                }
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            KorailChip(
                text = "자주쓰는카드",
                modifier = Modifier.clickableWithoutRipple {
                    showCardBottomSheet = true
                }
            )


            KorailBottomSheet(
                isOpenBottomSheet = showTrainBottomSheet,
                sheetState = sheetTrainState,
                title = "열차 조회",
                content = {
                    TrainSelectContent()
                },
                onDismissRequest = {
                    showTrainBottomSheet = false
                }
            )

            KorailBottomSheet(
                isOpenBottomSheet = showCardBottomSheet,
                sheetState = sheetCardState,
                title = "자주쓰는카드",
                content = {
                    CardSelectContent()
                },
                onDismissRequest = {
                    showCardBottomSheet = false
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        TrainSearchScreen()
    }
}
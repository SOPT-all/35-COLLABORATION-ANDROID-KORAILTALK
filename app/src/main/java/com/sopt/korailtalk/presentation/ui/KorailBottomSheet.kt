package com.sopt.korailtalk.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KorailBottomSheet(
    isOpenBottomSheet: Boolean,
    title: String,
    content: @Composable () -> Unit,
    sheetState: SheetState,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()
    if (isOpenBottomSheet) {
        coroutineScope.launch {
            sheetState.show()
        }

        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp),
            containerColor = KorailTalkTheme.colors.white,
            contentColor = KorailTalkTheme.colors.blue02,
            dragHandle = null
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = title,
                        style = KorailTalkTheme.typography.title1.copy(
                            color = KorailTalkTheme.colors.black
                        ),
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_close_black),
                        contentDescription = "닫기",
                        modifier = Modifier.clickable {
                            onDismissRequest()
                        }
                    )
                }
                content()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ShowKorailBottomSheet() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            val sheetTrainState = rememberModalBottomSheetState()
            var showTrainBottomSheet by remember { mutableStateOf(false) }

            val sheetCardState = rememberModalBottomSheetState()
            var showCardBottomSheet by remember { mutableStateOf(false) }

            KorailChip(
                text = "KTX 009",
                modifier = Modifier.clickable {
                    showTrainBottomSheet = true
                }
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            KorailChip(
                text = "자주쓰는카드",
                modifier = Modifier.clickable {
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


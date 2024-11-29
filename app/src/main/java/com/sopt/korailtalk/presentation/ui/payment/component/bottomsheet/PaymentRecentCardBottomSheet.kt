package com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.sopt.korailtalk.domain.type.RecentCardType
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.KorailOptionBottomSheetItem
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentRecentCardBottomSheet(
    showRecentCardBottomSheet: Boolean,
    onRecentCardBottomSheetStateChange: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    var selectedOptionIndex by remember { mutableIntStateOf(0) }
    val options = RecentCardType.entries.toTypedArray()

    KorailBottomSheet(
        isOpenBottomSheet = showRecentCardBottomSheet,
        title = "자주쓰는카드",
        content = {
            options.forEachIndexed { index, option ->
                KorailOptionBottomSheetItem(
                    option = option.text,
                    isActive = selectedOptionIndex == index,
                    activeBgColor = KorailTalkTheme.colors.purple05,
                    activeContentColor = KorailTalkTheme.colors.purple02,
                    onClick = {
                        selectedOptionIndex = if (selectedOptionIndex == index) -1 else index
                    }
                )
            }
        },
        sheetState = sheetState,
        onDismissRequest = onRecentCardBottomSheetStateChange
    )
}
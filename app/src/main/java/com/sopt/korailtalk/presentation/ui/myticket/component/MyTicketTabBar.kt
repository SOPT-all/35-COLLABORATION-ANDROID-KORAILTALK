package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun MyTicketTabBar(
    myTicketTabText: List<String>,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = KorailTalkTheme.colors.white,
        contentColor = KorailTalkTheme.colors.white,
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = KorailTalkTheme.colors.blue01
            )
        },
        divider = {}
    ) {
        myTicketTabText.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                text = {
                    Text(
                        text = tab,
                        style = KorailTalkTheme.typography.title1,
                        color = if (selectedTabIndex == index) KorailTalkTheme.colors.blue01 else KorailTalkTheme.colors.grey400,
                    )
                }
            )
        }

    }
}
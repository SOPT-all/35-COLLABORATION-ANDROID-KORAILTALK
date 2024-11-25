package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.domain.type.MyTicketTabType
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun MyTicketTabBar(
    myTicketTabText: Array<MyTicketTabType>,
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
                        text = tab.text,
                        style = KorailTalkTheme.typography.title1,
                        color = if (selectedTabIndex == index) KorailTalkTheme.colors.blue01 else KorailTalkTheme.colors.grey400,
                    )
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowMyTicketTabBar() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            val myTicketTabText = MyTicketTabType.entries.toTypedArray()

            MyTicketTabBar(myTicketTabText = myTicketTabText)
        }
    }
}
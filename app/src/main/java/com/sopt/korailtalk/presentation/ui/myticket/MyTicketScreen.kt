package com.sopt.korailtalk.presentation.ui.myticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.korailtalk.domain.type.MyTicketTabType
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketAdditionalService
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketAdditionalServiceType
import com.sopt.korailtalk.presentation.ui.myticket.component.MyTicketTabBar
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme

@Composable
fun MyTicketScreen() {
    val myTicketTabText = MyTicketTabType.entries.toTypedArray()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            MyTicketTabBar(myTicketTabText = myTicketTabText)


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                for (item in MyTicketAdditionalServiceType.entries) {
                    MyTicketAdditionalService(
                        image = {
                            Image(
                                painter = painterResource(item.imageId),
                                contentDescription = item.text
                            )
                        },
                        text = item.text,
                        textColor = item.textColor,
                    )
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        MyTicketScreen()
    }
}
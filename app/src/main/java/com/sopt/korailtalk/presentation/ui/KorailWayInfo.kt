package com.sopt.korailtalk.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography
import com.sopt.korailtalk.ui.theme.LocalColors

@Composable
fun KorailWayInfo(
    departurePlace: String,
    arrivalPlace: String
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = LocalColors.current.white)
        .padding(23.dp)){
        Text(text = departurePlace,
            style = typography.head5,
            modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.icn_arrow_circle),
            contentDescription = "열차 조회 화살표",
            modifier = Modifier.padding(horizontal = 26.dp)
        )
        Text(text = arrivalPlace,
            style = typography.head5,
            modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun KorailWayInfoPreview(){
    KorailWayInfo("서울","부산")
}
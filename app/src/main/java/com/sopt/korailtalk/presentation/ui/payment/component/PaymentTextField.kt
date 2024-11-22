package com.sopt.korailtalk.presentation.ui.payment.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentTextField(
    title: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    unit: String = "",
) {
    Box(
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = KorailTalkTheme.colors.white,
                borderColor = KorailTalkTheme.colors.grey200,
                borderWidth = 1.dp
            ),
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = KorailTalkTheme.colors.black,
                style = KorailTalkTheme.typography.caption2
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = KorailTalkTheme.typography.body2.copy(
                        color = KorailTalkTheme.colors.blue01,
                        textAlign = TextAlign.End
                    ),
                    singleLine = true,
                    cursorBrush = SolidColor(KorailTalkTheme.colors.blue04),
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            if (value.isBlank()) {
                                Text(
                                    text = hint,
                                    color = KorailTalkTheme.colors.grey300,
                                    style = KorailTalkTheme.typography.body2
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
            if (unit.isNotBlank()) {
                Text(
                    text = unit,
                    modifier = Modifier.padding(start = 4.dp),
                    color = KorailTalkTheme.colors.grey900,
                    style = KorailTalkTheme.typography.body2
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentTextField() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        var text by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentTextField(
                    title = "마일리지",
                    hint = "2000",
                    value = text,
                    onValueChange = { newValue -> text = newValue },
                    modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.717).dp),
                    unit = "점"
                )
                Spacer(modifier = Modifier.width(4.dp))
                PaymentChipButton(
                    title = "전액적용",
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
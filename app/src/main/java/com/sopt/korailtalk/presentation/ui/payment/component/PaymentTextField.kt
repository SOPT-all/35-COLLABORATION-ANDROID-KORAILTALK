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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    isNumber: Boolean = false,
    onDoneClick: (() -> Unit)? = null
) {
    val keyboardController = LocalSoftwareKeyboardController.current

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
                    keyboardOptions = KeyboardOptions(
                        keyboardType = if(isNumber) KeyboardType.Number else KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            onDoneClick?.invoke()
                        }
                    ),
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            if (value.isBlank()) {
                                Text(
                                    text = hint,
                                    color = if (unit.isNotBlank()) KorailTalkTheme.colors.grey300 else KorailTalkTheme.colors.grey400,
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
                    modifier = Modifier.weight(1f),
                    unit = "점"
                )
                Spacer(modifier = Modifier.width(4.dp))
                PaymentChipButton(
                    title = "전액적용",
                    onClick = {}
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            PaymentTextField(
                title = "보훈번호",
                hint = "보훈번호 8자리",
                value = text,
                onValueChange = { newValue -> text = newValue },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            PaymentTextField(
                title = "비밀번호",
                hint = "숫자 4자리(최초 주민번호 앞 4자리)",
                value = text,
                onValueChange = { newValue -> text = newValue },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentTextField(
                    title = "인증번호",
                    hint = "주민번호 앞자리 6자리",
                    value = text,
                    onValueChange = { newValue -> text = newValue },
                    modifier = Modifier.weight(1f),
                )
                Spacer(modifier = Modifier.width(4.dp))
                PaymentChipButton(
                    title = "보훈번호 확인",
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentTextField(
                    title = "포인트 비밀번호",
                    hint = "비밀번호 6자리",
                    value = text,
                    onValueChange = { newValue -> text = newValue },
                    modifier = Modifier.weight(1f),
                )
                Spacer(modifier = Modifier.width(4.dp))
                PaymentChipButton(
                    title = "조회하기",
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentTextField(
                    title = "사용 포인트",
                    hint = "1483",
                    value = text,
                    onValueChange = { newValue -> text = newValue },
                    modifier = Modifier.weight(1f),
                    unit = "P"
                )
                Spacer(modifier = Modifier.width(4.dp))
                PaymentChipButton(
                    title = "전액적용",
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                PaymentTextField(
                    title = "카드번호",
                    hint = "0000 - 0000 - 0000 - 0000",
                    value = text,
                    onValueChange = { newValue -> text = newValue },
                    modifier = Modifier.weight(1f),
                )
                Spacer(modifier = Modifier.width(4.dp))
                PaymentChipButton(
                    title = "카드스캔",
                    onClick = {}
                )
            }
        }
    }
}
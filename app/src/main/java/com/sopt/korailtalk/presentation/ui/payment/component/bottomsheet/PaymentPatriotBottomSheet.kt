package com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.domain.type.PaymentDropdownOptionType
import com.sopt.korailtalk.presentation.ui.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentChipButton
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentDropdownOption
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentSquareButton
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentPatriotBottomSheet(
    showPatriotBottomSheet: Boolean,
    onPatriotBottomSheetStateChange: () -> Unit,
    patriotNumber: String,
    updatePatriotNumber: (String) -> Unit,
    patriotPassword: String,
    updatePatriotPassword: (String) -> Unit,
    patriotCertificationNumber: String,
    updatePatriotCertificationNumber: (String) -> Unit,
    applyPatriotDiscount: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    KorailBottomSheet(
        isOpenBottomSheet = showPatriotBottomSheet,
        title = "국가유공자 할인",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .imePadding()
            ) {
                PaymentTextField(
                    title = "보훈번호",
                    hint = "보훈번호 8자리",
                    value = patriotNumber,
                    onValueChange = updatePatriotNumber,
                    modifier = Modifier.fillMaxWidth(),
                    isNumber = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                PaymentTextField(
                    title = "비밀번호",
                    hint = "숫자 4자리(최초 주민번호 앞 4자리)",
                    value = patriotPassword,
                    onValueChange = updatePatriotPassword,
                    modifier = Modifier.fillMaxWidth(),
                    isNumber = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PaymentTextField(
                        title = "인증번호",
                        hint = "주민번호 앞자리 6자리",
                        value = patriotCertificationNumber,
                        onValueChange = updatePatriotCertificationNumber,
                        modifier = Modifier.weight(1f),
                        isNumber = true
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    PaymentChipButton(
                        title = "보훈번호 확인",
                        onClick = {}
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                PaymentDropdownOption(
                    title = "적용대상",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    description = "어른 - 7호차 16A / 12,500원",
                    state = PaymentDropdownOptionType.SELECTED
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            PaymentSquareButton(
                title = "할인적용",
                enabled = true,
                onClick = applyPatriotDiscount
            )
        },
        sheetState = sheetState,
        onDismissRequest = onPatriotBottomSheetStateChange
    )
}
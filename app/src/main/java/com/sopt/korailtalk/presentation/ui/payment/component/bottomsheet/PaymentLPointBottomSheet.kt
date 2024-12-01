package com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.presentation.ui.core.KorailBottomSheet
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentChipButton
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentSquareButton
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentTextField
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentLPointBottomSheet(
    showLPointBottomSheet: Boolean,
    onLPointBottomSheetStateChange: () -> Unit,
    pointPassword: String,
    updatePointPassword: (String) -> Unit,
    onGetLPointClick: () -> Unit,
    lPoint: String,
    availableLPoint: Int,
    updateLPoint: (String) -> Unit,
    isLPointPrivacyChecked: Boolean,
    onLPointPrivacyCheckedStateChange: () -> Unit,
    applyLPointDiscount: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()


    KorailBottomSheet(
        isOpenBottomSheet = showLPointBottomSheet,
        title = "L.POINT",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Row {
                    PaymentTextField(
                        title = "포인트 비밀번호",
                        hint = "비밀번호 6자리",
                        value = pointPassword,
                        onValueChange = updatePointPassword,
                        modifier = Modifier.weight(1f),
                        isNumber = true
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    PaymentChipButton(
                        title = "조회하기",
                        onClick = onGetLPointClick
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    PaymentTextField(
                        title = "사용 포인트",
                        hint = "$availableLPoint",
                        value = lPoint,
                        onValueChange = updateLPoint,
                        modifier = Modifier.weight(1f),
                        unit = "P",
                        isNumber = true
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    PaymentChipButton(
                        title = "전액적용",
                        onClick = { updateLPoint(availableLPoint.toString())}
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "사용 가능 포인트: ${availableLPoint}점",
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(bottom = 16.dp),
                    color = KorailTalkTheme.colors.grey500,
                    style = KorailTalkTheme.typography.caption2
                )
                Text(
                    text = "100P 단위 사용 가능\n" +
                            "결제 비밀번호는 L.POINT 홈페이지 또는 앱에서 확인 가능\n" +
                            "L.POINT 일부 유형 포인트 사용 불가 (상품권 포인트, 전환적립, 및 판촉포인트 등)",
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    color = KorailTalkTheme.colors.grey500,
                    style = KorailTalkTheme.typography.caption4
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = if (isLPointPrivacyChecked) R.drawable.ic_payment_privacy_selected else R.drawable.ic_payment_privacy_not_selected),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickableWithoutRipple(onClick = onLPointPrivacyCheckedStateChange)
                    )
                    Text(
                        text = "개인정보 수집 및 이용동의",
                        color = KorailTalkTheme.colors.grey800,
                        style = KorailTalkTheme.typography.body2
                    )
                }
            }
            PaymentSquareButton(
                title = "입력 완료",
                enabled = isLPointPrivacyChecked,
                onClick = applyLPointDiscount
            )
        },
        sheetState = sheetState,
        onDismissRequest = onLPointBottomSheetStateChange
    )
}
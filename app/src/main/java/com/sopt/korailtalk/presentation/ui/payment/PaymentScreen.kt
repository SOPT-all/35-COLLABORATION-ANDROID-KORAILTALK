package com.sopt.korailtalk.presentation.ui.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.korailtalk.R
import com.sopt.korailtalk.domain.type.PaymentDropdownOptionType
import com.sopt.korailtalk.domain.type.PaymentSelectableOptionType
import com.sopt.korailtalk.presentation.ui.core.KorailRoundedButton
import com.sopt.korailtalk.presentation.ui.core.KorailSingleActionTopAppBar
import com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet.PaymentCardTypeBottomSheet
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentChipButton
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentDropdownOption
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentHorizontalDiver
import com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet.PaymentInstallmentBottomSheet
import com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet.PaymentLPointBottomSheet
import com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet.PaymentPatriotBottomSheet
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentRadioButtonOption
import com.sopt.korailtalk.presentation.ui.payment.component.bottomsheet.PaymentRecentCardBottomSheet
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentSelectableOption
import com.sopt.korailtalk.presentation.ui.payment.component.PaymentTextField
import com.sopt.korailtalk.presentation.util.clickableWithoutRipple
import com.sopt.korailtalk.presentation.util.showIf
import com.sopt.korailtalk.presentation.util.toKoreanCurrency
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun PaymentRoute(
    paymentViewModel: PaymentViewModel = hiltViewModel(),
    ticketId: Long,
    navigateToMyTicket: (Long) -> Unit,
) {
    PaymentScreen(
        priceBeforeDiscount = paymentViewModel.priceBeforeDiscount.collectAsState().value,
        priceAfterDiscount = paymentViewModel.priceAfterDiscount.collectAsState().value,
        discount = paymentViewModel.discount.collectAsState().value,
        updateDiscount = { newValue -> paymentViewModel.updateDiscount(newValue.toInt()) },
        isKTXMileageSectionSelected = paymentViewModel.isKtxMileageSectionSelected.collectAsState().value,
        onKTXMileageSectionStateChange = { paymentViewModel.changeKTXMileageSectionState() },
        ktxMileage = paymentViewModel.ktxMileage.collectAsState().value,
        updateKTXMileage = { newValue -> paymentViewModel.updateKTXMileage(newValue) },
        isDiscountCouponSectionSelected = paymentViewModel.isDiscountCouponSectionSelected.collectAsState().value,
        onDiscountCouponSectionStateChange = { paymentViewModel.changeDiscountCouponSectionState() },
        showPatriotBottomSheet = paymentViewModel.showPatriotBottomSheet.collectAsState().value,
        onPatriotBottomSheetStateChange = { paymentViewModel.changePatriotBottomSheet() },
        patriotNumber = paymentViewModel.patriotNumber.collectAsState().value,
        updatePatriotNumber = { newValue -> paymentViewModel.updatePatriotNumber(newValue) },
        patriotPassword = paymentViewModel.patriotPassword.collectAsState().value,
        updatePatriotPassword = { newValue -> paymentViewModel.updatePatriotPassword(newValue)},
        patriotCertificationNumber = paymentViewModel.patriotCertificationNumber.collectAsState().value,
        updatePatriotCertificationNumber = { newValue -> paymentViewModel.updatePatriotCertificationNumber(newValue) },
        isPointUsageSectionSelected = paymentViewModel.isPointUsageSectionSelected.collectAsState().value,
        onPointUsageSectionStateChange = { paymentViewModel.changePointUsageSectionState() },
        showLPointBottomSheet = paymentViewModel.showLPointBottomSheet.collectAsState().value,
        onLPointBottomSheetStateChange = { paymentViewModel.changeLPointBottomSheet() },
        pointPassword = paymentViewModel.pointPassword.collectAsState().value,
        updatePointPassword = { newValue -> paymentViewModel.updatePointPassword(newValue) },
        onGetLPointClick = { paymentViewModel.getLPoint()},
        lPointState = paymentViewModel.lPointState.collectAsState().value,
        lPoint = paymentViewModel.lPoint.collectAsState().value,
        updateLPoint = { newValue -> paymentViewModel.updateLPoint(newValue) },
        isLPointPrivacyChecked = paymentViewModel.isLPointPrivacyChecked.collectAsState().value,
        onLPointPrivacyCheckedStateChange = { paymentViewModel.changeLPointPrivacyCheckedState() },
        isEasyPaymentSectionSelected = paymentViewModel.isEasyPaymentSectionSelected.collectAsState().value,
        onEasyPaymentSectionStateChange = { paymentViewModel.changeEasyPaymentSectionState() },
        isKaKaoPaySelected = paymentViewModel.isKaKaoPaySelected.collectAsState().value,
        onKaKaoPayClick = { paymentViewModel.changeKaKaoPayState() },
        isCardPaymentSectionSelected = paymentViewModel.isCardPaymentSectionSelected.collectAsState().value,
        onCardPaymentSectionStateChange = { paymentViewModel.changeCardPaymentSectionState() },
        showRecentCardBottomSheet = paymentViewModel.showRecentCardBottomSheet.collectAsState().value,
        onRecentCardBottomSheetStateChange = { paymentViewModel.changeRecentCardBottomSheet() },
        cardNumber = paymentViewModel.cardNumber.collectAsState().value,
        updateCardNumber = { newValue -> paymentViewModel.updateCardNumber(newValue) },
        cardExpirationPeriod = paymentViewModel.cardExpirationPeriod.collectAsState().value,
        updateCardExpirationPeriod = { newValue -> paymentViewModel.updateCardExpirationPeriod(newValue) },
        cardPassword = paymentViewModel.cardPassword.collectAsState().value,
        updateCardPassword = { newValue -> paymentViewModel.updateCardPassword(newValue) },
        showCardTypeBottomSheet = paymentViewModel.showCardTypeBottomSheet.collectAsState().value,
        onCardTypeBottomSheetStateChange = { paymentViewModel.changeCardTypeBottomSheet() },
        cardCertificationNumber = paymentViewModel.cardCertificationNumber.collectAsState().value,
        updateCardCertificationNumber = { newValue -> paymentViewModel.updateCardCertificationNumber(newValue) },
        showInstallmentBottomSheet = paymentViewModel.showInstallmentBottomSheet.collectAsState().value,
        onInstallmentBottomSheetChange = { paymentViewModel.changeInstallmentBottomSheet() },
        isCardPaymentPrivacyChecked = paymentViewModel.isCardPaymentPrivacyChecked.collectAsState().value,
        onCardPaymentPrivacyCheckedStateChange = { paymentViewModel.changeCardPaymentPrivacyCheckedState() },
        ticketBuyingState = paymentViewModel.ticketBuyingState.collectAsState().value,
        onTicketBuyingClick = {
            paymentViewModel.buyTicket(ticketId = ticketId)
            navigateToMyTicket(ticketId)
        }
    )
}

@Composable
fun PaymentScreen(
    priceBeforeDiscount: Int,
    priceAfterDiscount: Int,
    discount: Int,
    updateDiscount: (String) -> Unit,
    isKTXMileageSectionSelected: Boolean,
    onKTXMileageSectionStateChange: () -> Unit,
    ktxMileage: String,
    updateKTXMileage: (String) -> Unit,
    isDiscountCouponSectionSelected: Boolean,
    onDiscountCouponSectionStateChange: () -> Unit,
    showPatriotBottomSheet: Boolean,
    onPatriotBottomSheetStateChange: () -> Unit,
    patriotNumber: String,
    updatePatriotNumber: (String) -> Unit,
    patriotPassword: String,
    updatePatriotPassword: (String) -> Unit,
    patriotCertificationNumber: String,
    updatePatriotCertificationNumber: (String) -> Unit,
    isPointUsageSectionSelected: Boolean,
    onPointUsageSectionStateChange: () -> Unit,
    showLPointBottomSheet: Boolean,
    onLPointBottomSheetStateChange: () -> Unit,
    pointPassword: String,
    updatePointPassword: (String) -> Unit,
    onGetLPointClick: () -> Unit,
    lPointState: LPointState,
    lPoint: String,
    updateLPoint: (String) -> Unit,
    isLPointPrivacyChecked: Boolean,
    onLPointPrivacyCheckedStateChange: () -> Unit,
    isEasyPaymentSectionSelected: Boolean,
    onEasyPaymentSectionStateChange: () -> Unit,
    isKaKaoPaySelected: PaymentSelectableOptionType,
    onKaKaoPayClick: () -> Unit,
    isCardPaymentSectionSelected: Boolean,
    onCardPaymentSectionStateChange: () -> Unit,
    showRecentCardBottomSheet: Boolean,
    onRecentCardBottomSheetStateChange: () -> Unit,
    cardNumber: String,
    updateCardNumber: (String) -> Unit,
    cardExpirationPeriod: String,
    updateCardExpirationPeriod: (String) -> Unit,
    cardPassword: String,
    updateCardPassword: (String) -> Unit,
    showCardTypeBottomSheet: Boolean,
    onCardTypeBottomSheetStateChange: () -> Unit,
    cardCertificationNumber: String,
    updateCardCertificationNumber: (String) -> Unit,
    showInstallmentBottomSheet: Boolean,
    onInstallmentBottomSheetChange: ()  -> Unit,
    isCardPaymentPrivacyChecked: Boolean,
    onCardPaymentPrivacyCheckedStateChange: () -> Unit,
    ticketBuyingState: TicketBuyingState,
    onTicketBuyingClick: () -> Unit,
) {
    var patriotDescription by remember { mutableStateOf("") }
    var patriotApplyState by remember { mutableStateOf(PaymentDropdownOptionType.UNSELECTED) }
    var lPointDiscountState by remember { mutableStateOf(PaymentSelectableOptionType.ENABLED) }

    Column(

        modifier = Modifier.fillMaxSize(),
    ) {
        KorailSingleActionTopAppBar(
            title = "결제하기",
            backgroundColor = KorailTalkTheme.colors.purple02,
            iconId = R.drawable.ic_topappbar_x_24,
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "승차권",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title1
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = priceBeforeDiscount.toKoreanCurrency(),
                            color = KorailTalkTheme.colors.purple04,
                            style = KorailTalkTheme.typography.head3
                        )
                    }
                    Text(
                        text = "*특(우등)실은 운임과 요금으로 구성되며 운임만 할인됨",
                        color = KorailTalkTheme.colors.red,
                        style = KorailTalkTheme.typography.caption4
                    )
                }
            }

            item { PaymentHorizontalDiver() }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                ) {
                    Text(
                        text = "할인",
                        modifier = Modifier.padding(bottom = 16.dp),
                        color = KorailTalkTheme.colors.black,
                        style = KorailTalkTheme.typography.title1
                    )
                    PaymentRadioButtonOption(
                        title = "KTX 마일리지",
                        selected = isKTXMileageSectionSelected,
                        onClick = onKTXMileageSectionStateChange
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                            .showIf(isKTXMileageSectionSelected)
                    ) {
                        Row {
                            PaymentTextField(
                                title = "마일리지",
                                hint = "2000",
                                value = ktxMileage,
                                onValueChange = updateKTXMileage,
                                modifier = Modifier.weight(1f),
                                unit = "점",
                                isNumber = true,
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            PaymentChipButton(
                                title = "전액적용",
                                onClick = { updateKTXMileage("2000") }
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "사용 가능 마일리지 : 2000점",
                            modifier = Modifier.align(Alignment.End),
                            color = KorailTalkTheme.colors.grey500,
                            style = KorailTalkTheme.typography.caption2
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "100마일리지 이상 100마일리 단위로 사용",
                            modifier = Modifier.align(Alignment.End),
                            color = KorailTalkTheme.colors.grey400,
                            style = KorailTalkTheme.typography.caption4
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    PaymentRadioButtonOption(
                        title = "할인쿠폰",
                        selected = isDiscountCouponSectionSelected,
                        onClick = onDiscountCouponSectionStateChange
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                            .showIf(isDiscountCouponSectionSelected)
                    ) {
                        PaymentDropdownOption(
                            title = "할인쿠폰",
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        PaymentDropdownOption(
                            title = "국가유공자 할인",
                            onClick = onPatriotBottomSheetStateChange,
                            modifier = Modifier.fillMaxWidth(),
                            description = patriotDescription,
                            state = patriotApplyState
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        PaymentDropdownOption(
                            title = "국가유공자 보호자 할인",
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            description = "적용대상 없음",
                            state = PaymentDropdownOptionType.UNENABLED
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        PaymentDropdownOption(
                            title = "중증 보호자 할인",
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            description = "적용대상 없음",
                            state = PaymentDropdownOptionType.UNENABLED
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        PaymentDropdownOption(
                            title = "현역병 할인",
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "추가로 할인 가능한 항목이 있으신 경우 할인을 적용해주세요.\n" +
                                    "추가할인은 어른/청소년 기준, 예매한 매수만큼 적용할 수 있습니다.\n\n" +
                                    "경증 : 장애의 정도가 심하지 않은 장애인(구 4-6급)\n" +
                                    "중증 : 장애의 정도가 심한 장애인(구 1-3급)",
                            color = KorailTalkTheme.colors.grey500,
                            style = KorailTalkTheme.typography.caption4
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    PaymentRadioButtonOption(
                        title = "포인트 사용",
                        selected = isPointUsageSectionSelected,
                        onClick = onPointUsageSectionStateChange
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                            .showIf(isPointUsageSectionSelected)
                    ) {
                        PaymentSelectableOption(
                            onClick = onLPointBottomSheetStateChange,
                            modifier = Modifier.fillMaxWidth(),
                            title = "L.POINT",
                            state = lPointDiscountState
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "레일포인트",
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "위바꿀 (모아)",
                                state = PaymentSelectableOptionType.UNENABLED
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "씨티포인트",
                                state = PaymentSelectableOptionType.UNENABLED,
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "OK캐쉬백포인트",
                            )
                        }
                    }
                }
            }

            item { PaymentHorizontalDiver() }

            item { // 결제수단 선택 Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                ) {
                    Text(
                        text = "결제수단 선택",
                        modifier = Modifier.padding(bottom = 16.dp),
                        color = KorailTalkTheme.colors.black,
                        style = KorailTalkTheme.typography.title1
                    )
                    PaymentRadioButtonOption(
                        title = "간편결제",
                        selected = isEasyPaymentSectionSelected,
                        onClick = onEasyPaymentSectionStateChange
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .showIf(isEasyPaymentSectionSelected)
                    ) {
                        PaymentSelectableOption(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            content = {
                                Row(
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_payment_korail_logo),
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "X",
                                        modifier = Modifier.padding(horizontal = 4.dp),
                                        color = KorailTalkTheme.colors.black,
                                        style = KorailTalkTheme.typography.head5
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.img_payment_tosspay_logo),
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "+ 결제수단 등록하기",
                                        color = KorailTalkTheme.colors.grey400,
                                        style = KorailTalkTheme.typography.caption2
                                    )
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "레일 플러스 카드"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "네이버페이 (머니)",
                                content = {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_payment_easypayment_event),
                                        contentDescription = null,
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "제로페이카드",
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "네이버페이 (카드)",
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "KB Pay",
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "토스페이",
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            PaymentSelectableOption(
                                onClick = onKaKaoPayClick,
                                modifier = Modifier.weight(1f),
                                title = "카카오페이",
                                state = isKaKaoPaySelected
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "신한SOL페이",
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "PAYCO",
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            PaymentSelectableOption(
                                onClick = {},
                                modifier = Modifier.weight(1f),
                                title = "BC페이북",
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    PaymentRadioButtonOption(
                        title = "카드결제",
                        selected = isCardPaymentSectionSelected,
                        onClick = onCardPaymentSectionStateChange
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .showIf(isCardPaymentSectionSelected)
                    ) {
                        PaymentDropdownOption(
                            title = "자주쓰는카드",
                            onClick = onRecentCardBottomSheetStateChange,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            description = "직접입력",
                            state = PaymentDropdownOptionType.SELECTED
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                        ) {
                            PaymentTextField(
                                title = "카드번호",
                                hint = "0000 - 0000 - 0000 - 0000",
                                value = cardNumber,
                                onValueChange = updateCardNumber,
                                modifier = Modifier.weight(1f),
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            PaymentChipButton(
                                title = "카드스캔",
                                onClick = {}
                            )
                        }
                        PaymentTextField(
                            title = "유효기간",
                            hint = "00 / 00",
                            value = cardExpirationPeriod,
                            onValueChange = updateCardExpirationPeriod,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        PaymentTextField(
                            title = "비밀번호",
                            hint = "00",
                            value = cardPassword,
                            onValueChange = updateCardPassword,
                            modifier = Modifier.padding(bottom = 8.dp),
                            unit = "**"
                        )
                        PaymentDropdownOption(
                            title = "카드종류",
                            onClick = onCardTypeBottomSheetStateChange,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            description = "개인",
                            state = PaymentDropdownOptionType.SELECTED
                        )
                        PaymentTextField(
                            title = "인증번호",
                            hint = "주민번호 앞 6자리",
                            value = cardCertificationNumber,
                            onValueChange = updateCardCertificationNumber,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        PaymentDropdownOption(
                            title = "할부기간",
                            onClick = onInstallmentBottomSheetChange,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            description = "일시불",
                            state = PaymentDropdownOptionType.SELECTED
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = if (isCardPaymentPrivacyChecked) R.drawable.ic_payment_privacy_selected else R.drawable.ic_payment_privacy_not_selected),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .clickableWithoutRipple(onClick = onCardPaymentPrivacyCheckedStateChange)
                            )
                            Text(
                                text = "개인정보 수집 및 이용동의",
                                color = KorailTalkTheme.colors.grey800,
                                style = KorailTalkTheme.typography.body2
                            )
                        }

                    }
                }
            }

            item { PaymentHorizontalDiver() }

            item { // 결제 상세 Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(bottom = 16.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = "결제 상세",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title1
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "어른 1명 - 1매",
                            color = KorailTalkTheme.colors.purple02,
                            style = KorailTalkTheme.typography.body2
                        )
                    }

                    Row(
                        modifier = Modifier.padding(bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "이용 금액",
                            color = KorailTalkTheme.colors.grey800,
                            style = KorailTalkTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = priceBeforeDiscount.toKoreanCurrency(),
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title3
                        )
                    }
                    Row(
                        modifier = Modifier.padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "할인 및 포인트",
                            color = KorailTalkTheme.colors.grey800,
                            style = KorailTalkTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = discount.toKoreanCurrency(),
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title3
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(color = KorailTalkTheme.colors.grey200)
                    )

                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "총 결제 금액",
                            color = KorailTalkTheme.colors.black,
                            style = KorailTalkTheme.typography.title3
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = priceAfterDiscount.toKoreanCurrency(),
                            color = KorailTalkTheme.colors.purple04,
                            style = KorailTalkTheme.typography.head5
                        )
                    }
                }
            }

            item { PaymentHorizontalDiver() }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = KorailTalkTheme.colors.transparentBlue95)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "총 1매",
                    color = KorailTalkTheme.colors.purple05,
                    style = KorailTalkTheme.typography.body2
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = priceAfterDiscount.toKoreanCurrency(),
                    color = KorailTalkTheme.colors.white,
                    style = KorailTalkTheme.typography.head5
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        KorailRoundedButton(
            title = "발권하기",
            modifier = Modifier
                .height((LocalConfiguration.current.screenHeightDp * 0.064).dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            enabled = isCardPaymentPrivacyChecked,
            contentColor = KorailTalkTheme.colors.white,
            cornerRadius = 26.dp,
            backgroundColor = KorailTalkTheme.colors.purple03,
            onClick = onTicketBuyingClick
        )
        Spacer(modifier = Modifier.height(10.dp))

        PaymentPatriotBottomSheet(
            showPatriotBottomSheet = showPatriotBottomSheet,
            onPatriotBottomSheetStateChange = onPatriotBottomSheetStateChange,
            patriotNumber = patriotNumber,
            updatePatriotNumber = updatePatriotNumber,
            patriotPassword = patriotPassword,
            updatePatriotPassword = updatePatriotPassword,
            patriotCertificationNumber = patriotCertificationNumber,
            updatePatriotCertificationNumber = updatePatriotCertificationNumber,
            applyPatriotDiscount = {
                patriotDescription = "500원 할인"
                patriotApplyState = PaymentDropdownOptionType.APPLIED
                onPatriotBottomSheetStateChange()
                updateDiscount("500")
            }
        )

        PaymentLPointBottomSheet(
            showLPointBottomSheet = showLPointBottomSheet,
            onLPointBottomSheetStateChange = onLPointBottomSheetStateChange,
            pointPassword = pointPassword,
            updatePointPassword = updatePointPassword,
            onGetLPointClick = onGetLPointClick,
            lPoint = lPoint,
            availableLPoint = when(lPointState) {
                is LPointState.Success -> lPointState.data.point
                else -> 0
            },
            updateLPoint = updateLPoint,
            isLPointPrivacyChecked = isLPointPrivacyChecked,
            onLPointPrivacyCheckedStateChange = onLPointPrivacyCheckedStateChange,
            applyLPointDiscount = {
                updateDiscount(lPoint)
                onLPointBottomSheetStateChange()
                lPointDiscountState = PaymentSelectableOptionType.SELECTED
            }
        )

        PaymentRecentCardBottomSheet(
            showRecentCardBottomSheet = showRecentCardBottomSheet,
            onRecentCardBottomSheetStateChange = onRecentCardBottomSheetStateChange
        )
        PaymentCardTypeBottomSheet(
            showCardTypeBottomSheet = showCardTypeBottomSheet,
            onCardTypeBottomSheetStateChange = onCardTypeBottomSheetStateChange
        )

        PaymentInstallmentBottomSheet(
            showInstallmentBottomSheet = showInstallmentBottomSheet,
            onInstallmentBottomSheetChange = onInstallmentBottomSheetChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPaymentScreen() {
    COLLAVORATIONANDROIDKORAILTALKTheme {

    }
}
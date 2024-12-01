package com.sopt.korailtalk.presentation.ui.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.korailtalk.domain.model.TicketBuying
import com.sopt.korailtalk.domain.repository.PaymentRepository
import com.sopt.korailtalk.domain.type.PaymentSelectableOptionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val paymentRepository: PaymentRepository
) : ViewModel() {
    private val _priceBeforeDiscount = MutableStateFlow(12500)
    val priceBeforeDiscount: StateFlow<Int> = _priceBeforeDiscount

    private val _discount = MutableStateFlow(0)
    val discount: StateFlow<Int> = _discount

    val priceAfterDiscount: StateFlow<Int> = combine(_priceBeforeDiscount, _discount) { before, discount ->
        before - discount
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = _priceBeforeDiscount.value - _discount.value
    )

    private val _isKtxMileageSectionSelected = MutableStateFlow(false)
    val isKtxMileageSectionSelected: StateFlow<Boolean> = _isKtxMileageSectionSelected

    private val _ktxMileage = MutableStateFlow("")
    val ktxMileage: StateFlow<String> = _ktxMileage

    private val _isDiscountCouponSectionSelected = MutableStateFlow(false)
    val isDiscountCouponSectionSelected: StateFlow<Boolean> = _isDiscountCouponSectionSelected

    private val _showPatriotBottomSheet = MutableStateFlow(false)
    val showPatriotBottomSheet: StateFlow<Boolean> = _showPatriotBottomSheet

    private val _patriotNumber = MutableStateFlow("")
    val patriotNumber: StateFlow<String> = _patriotNumber

    private val _patriotPassword = MutableStateFlow("")
    val patriotPassword: StateFlow<String> = _patriotPassword

    private val _patriotCertificationNumber = MutableStateFlow("")
    val patriotCertificationNumber: StateFlow<String> = _patriotCertificationNumber

    private val _isPointUsageSectionSelected = MutableStateFlow(false)
    val isPointUsageSectionSelected: StateFlow<Boolean> = _isPointUsageSectionSelected

    private val _showLPointBottomSheet = MutableStateFlow(false)
    val showLPointBottomSheet: StateFlow<Boolean> = _showLPointBottomSheet

    private val _pointPassword = MutableStateFlow("")
    val pointPassword: StateFlow<String> = _pointPassword

    private val _lPointState = MutableStateFlow<LPointState>(LPointState.Idle)
    val lPointState: StateFlow<LPointState> = _lPointState

    private val _lPoint = MutableStateFlow("")
    val lPoint: StateFlow<String> = _lPoint

    private val _isLPointPrivacyChecked = MutableStateFlow(false)
    val isLPointPrivacyChecked: StateFlow<Boolean> = _isLPointPrivacyChecked

    private val _isEasyPaymentSectionSelected = MutableStateFlow(false)
    val isEasyPaymentSectionSelected: StateFlow<Boolean> = _isEasyPaymentSectionSelected

    private val _isKaKaoPaySelected = MutableStateFlow(PaymentSelectableOptionType.ENABLED)
    val isKaKaoPaySelected: StateFlow<PaymentSelectableOptionType> = _isKaKaoPaySelected

    private val _isCardPaymentSectionSelected = MutableStateFlow(false)
    val isCardPaymentSectionSelected: StateFlow<Boolean> = _isCardPaymentSectionSelected

    private val _showRecentCardBottomSheet = MutableStateFlow(false)
    val showRecentCardBottomSheet: StateFlow<Boolean> = _showRecentCardBottomSheet

    private val _cardNumber = MutableStateFlow("")
    val cardNumber: StateFlow<String> = _cardNumber

    private val _cardExpirationPeriod = MutableStateFlow("")
    val cardExpirationPeriod: StateFlow<String> = _cardExpirationPeriod

    private val _cardPassword = MutableStateFlow("")
    val cardPassword: StateFlow<String> = _cardPassword

    private val _showCardTypeBottomSheet = MutableStateFlow(false)
    val showCardTypeBottomSheet: StateFlow<Boolean> = _showCardTypeBottomSheet

    private val _cardCertificationNumber = MutableStateFlow("")
    val cardCertificationNumber: StateFlow<String> = _cardCertificationNumber

    private val _showInstallmentBottomSheet = MutableStateFlow(false)
    val showInstallmentBottomSheet: StateFlow<Boolean> = _showInstallmentBottomSheet

    private val _isCardPaymentPrivacyChecked = MutableStateFlow(false)
    val isCardPaymentPrivacyChecked: StateFlow<Boolean> = _isCardPaymentPrivacyChecked

    private val _ticketBuyingState = MutableStateFlow<TicketBuyingState>(TicketBuyingState.Idle)
    val ticketBuyingState: StateFlow<TicketBuyingState> = _ticketBuyingState

    fun updateDiscount(newValue: Int) {
        _discount.value = newValue
    }

    fun getLPoint(userId: Long = 1, pointPassword: Int = 123456) {
        _lPointState.value = LPointState.Loading
        viewModelScope.launch {
            val result = paymentRepository.getLpoint(userId = userId, pointPassword = pointPassword)
            _lPointState.value = result.fold(
                onSuccess = { LPointState.Success(it) },
                onFailure = { LPointState.Failure(it.message ?: "알 수 없는 오류") }
            )
        }
    }

    fun changeKTXMileageSectionState() {
        _isKtxMileageSectionSelected.value = !_isKtxMileageSectionSelected.value
    }

    fun updateKTXMileage(newValue: String) {
        val intValue = newValue.toIntOrNull() ?: 0
        _ktxMileage.value = if (intValue <= 2000) newValue else "2000"
    }

    fun changeDiscountCouponSectionState() {
        _isDiscountCouponSectionSelected.value = !_isDiscountCouponSectionSelected.value
    }

    fun changePatriotBottomSheet() {
        _showPatriotBottomSheet.value = !_showPatriotBottomSheet.value
    }

    fun updatePatriotNumber(newValue: String) {
        _patriotNumber.value = newValue
    }

    fun updatePatriotPassword(newValue: String) {
        _patriotPassword.value = newValue
    }

    fun updatePatriotCertificationNumber(newValue: String) {
        _patriotCertificationNumber.value = newValue
    }

    fun changePointUsageSectionState() {
        _isPointUsageSectionSelected.value = !_isPointUsageSectionSelected.value
    }

    fun changeLPointBottomSheet() {
        _showLPointBottomSheet.value = !_showLPointBottomSheet.value
    }

    fun updatePointPassword(newValue: String) {
        _pointPassword.value = newValue
    }

    fun updateLPoint(newValue: String) {
        _lPoint.value = newValue
    }

    fun changeLPointPrivacyCheckedState() {
        _isLPointPrivacyChecked.value = !_isLPointPrivacyChecked.value
    }

    fun changeEasyPaymentSectionState() {
        _isEasyPaymentSectionSelected.value = !isEasyPaymentSectionSelected.value
    }

    fun changeCardPaymentSectionState() {
        _isCardPaymentSectionSelected.value = !isCardPaymentSectionSelected.value
    }

    fun changeKaKaoPayState() {
        when (_isKaKaoPaySelected.value) {
            PaymentSelectableOptionType.UNENABLED -> {}
            PaymentSelectableOptionType.ENABLED -> {
                _isKaKaoPaySelected.value = PaymentSelectableOptionType.SELECTED
            }

            PaymentSelectableOptionType.SELECTED -> {
                _isKaKaoPaySelected.value = PaymentSelectableOptionType.ENABLED
            }
        }
    }

    fun changeRecentCardBottomSheet() {
        _showRecentCardBottomSheet.value = !_showRecentCardBottomSheet.value
    }

    fun updateCardNumber(newValue: String) {
        _cardNumber.value = newValue
    }

    fun updateCardExpirationPeriod(newValue: String) {
        _cardExpirationPeriod.value = newValue
    }

    fun updateCardPassword(newValue: String) {
        _cardPassword.value = newValue
    }

    fun changeCardTypeBottomSheet() {
        _showCardTypeBottomSheet.value = !_showCardTypeBottomSheet.value
    }

    fun updateCardCertificationNumber(newValue: String) {
        _cardCertificationNumber.value = newValue
    }

    fun changeInstallmentBottomSheet() {
        _showInstallmentBottomSheet.value = !_showInstallmentBottomSheet.value
    }

    fun changeCardPaymentPrivacyCheckedState() {
        _isCardPaymentPrivacyChecked.value = !_isCardPaymentPrivacyChecked.value
    }

    fun buyTicket(ticketId: Long = 29) {
        val totalPrice = priceAfterDiscount.value
        val usedPoint = _discount.value
        _ticketBuyingState.value = TicketBuyingState.Loading
        viewModelScope.launch {
            val result = paymentRepository.buyTicket(
                TicketBuying(
                    ticketId = ticketId,
                    totalPrice = totalPrice,
                    usedPoint = usedPoint
                )
            )
            _ticketBuyingState.value = result.fold(
                onSuccess = { TicketBuyingState.Success },
                onFailure = { TicketBuyingState.Failure(it.message ?: "알 수 없는 오류") }
            )
        }
    }
}
package com.sopt.korailtalk.domain.type

enum class InstallmentType(
    val text: String
) {
    NO_INSTALLMENT(
        text = "일시불"
    ),
    MONTH_3(
        text = "3개월"
    ),
    MONTH_6(
        text = "6개월"
    )
}
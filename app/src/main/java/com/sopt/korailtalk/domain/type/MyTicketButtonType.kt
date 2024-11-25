package com.sopt.korailtalk.domain.type

enum class MyTicketButtonType(
    val text: String,
) {
    TICKET(
        text = "승차권 전달"
    ),
    CANCLE(
        text = "예매 취소"
    ),
    CHANGE(
        text = "예매 변경"
    ),
}
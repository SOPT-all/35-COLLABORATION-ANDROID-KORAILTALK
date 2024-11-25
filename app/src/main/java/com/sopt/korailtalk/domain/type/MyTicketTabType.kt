package com.sopt.korailtalk.domain.type

enum class MyTicketTabType(
    val text: String,
) {
    TICKET(
        text = "승차권 (1)"
    ),
    PASS(
        text = "이용권"
    ),
    SEASON_PASS(
        text = "정기권 · 패스"
    )
}
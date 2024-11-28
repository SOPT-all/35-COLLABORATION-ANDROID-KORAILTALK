package com.sopt.korailtalk.domain.type

enum class SearchWayType (
    val text: String,
){
    DIRECT(
        text = "직통"
    ),
    TRANSFER(
        text = "환승"
    )
}
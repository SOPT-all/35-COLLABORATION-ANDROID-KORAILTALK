package com.sopt.korailtalk.domain.type

enum class SearchCarType (
    val text: String,
){
    BASIC(
        text = "일반석"
    ),
    TODDLER(
        text = "유아동반"
    ),
    WHEELCHAIR(
        text = "휠체어"
    ),
    AUTUWHEELCHAIR(
        text = "전동휠체어"
    ),
    SECOND_FLOOR(
        text = "2층석"
    ),
    BICYCLE(
        text = "자전거"
    ),
    HELPER(
        text = "대피도우미"
    )
}
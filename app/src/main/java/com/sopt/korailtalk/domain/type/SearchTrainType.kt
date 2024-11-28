package com.sopt.korailtalk.domain.type

enum class SearchTrainType (
    val text: String,
){
    ALL(
        text = "모든열차"
    ),
    KTX(
        text = "KTX"
    ),
    ITX(
        text = "ITX"
    ),
    MUGUNGHWA(
        text = "무궁화"
    )
}
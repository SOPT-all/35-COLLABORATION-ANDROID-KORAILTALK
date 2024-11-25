package com.sopt.korailtalk.domain.type

enum class SearchTrainType (
    val trainType: String,
){
    ALL(
        trainType = "모든열차"
    ),
    KTX(
        trainType = "KTX"
    ),
    ITX(
        trainType = "ITX"
    ),
    MUGUNGHWA(
        trainType = "무궁화"
    )
}
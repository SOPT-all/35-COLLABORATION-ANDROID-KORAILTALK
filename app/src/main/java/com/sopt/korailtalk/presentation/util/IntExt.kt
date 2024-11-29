package com.sopt.korailtalk.presentation.util

fun Int.toKoreanCurrency(): String {
    return String.format("%,d", this) + "원"
}
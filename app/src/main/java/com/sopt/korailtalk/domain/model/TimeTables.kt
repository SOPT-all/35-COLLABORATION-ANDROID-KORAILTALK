package com.sopt.korailtalk.domain.model

data class TimeTables(
   val timetables: List<TimeTable>
) {
    data class TimeTable(
        val timetableId: Long,
        val trainName: String,
        val departureTime: String,
        val arrivalTime: String,
        val standardPrice: Int,
        val premiumPrice: Int,
        val isStandardSold: Boolean,
        val isPremiumSold: Boolean,
        val travelTime: Int,
    )
}
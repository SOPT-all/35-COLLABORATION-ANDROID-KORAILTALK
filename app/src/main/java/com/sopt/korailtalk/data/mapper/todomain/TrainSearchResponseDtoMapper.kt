package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.TrainSearchResponseDto
import com.sopt.korailtalk.domain.model.TimeTable

fun TrainSearchResponseDto.toDomain(): List<TimeTable> = this.timeTables.map { timeTable ->
    TimeTable(
        timetableId = timeTable.timetableId,
        trainName = timeTable.trainName,
        departureTime = timeTable.departureTime,
        arrivalTime = timeTable.arrivalTime,
        standardPrice = timeTable.standardPrice,
        premiumPrice = timeTable.premiumPrice,
        isStandardSold = timeTable.isStandardSold,
        isPremiumSold = timeTable.isPremiumSold,
        travelTime = timeTable.travelTime
    )
}
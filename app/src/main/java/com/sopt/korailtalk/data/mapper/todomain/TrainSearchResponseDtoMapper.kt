package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.TrainSearchResponseDto
import com.sopt.korailtalk.domain.model.TimeTable
import com.sopt.korailtalk.domain.model.TimeTables

fun TrainSearchResponseDto.toDomain(): TimeTables {
    return TimeTables(
        timetables = this.timetables.map {
            TimeTable(
                timetableId = it.timetableId,
                trainName = it.trainName,
                departureTime = it.departureTime,
                arrivalTime = it.arrivalTime,
                standardPrice = it.standardPrice,
                premiumPrice = it.premiumPrice,
                isStandardSold = it.isStandardSold,
                isPremiumSold = it.isPremiumSold,
                travelTime = it.travelTime
            )
        }.toCollection(ArrayList())
    )
}
package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.TrainSearchResponseDto
import com.sopt.korailtalk.domain.model.TimeTables

fun TrainSearchResponseDto.toDomain(): TimeTables {
    return TimeTables(
        timetables = this.timetables.map { timetable ->
            TimeTables.TimeTable(
                timetableId = timetable.timetableId,
                trainName = timetable.trainName,
                departureTime = timetable.departureTime,
                arrivalTime = timetable.arrivalTime,
                standardPrice = timetable.standardPrice,
                premiumPrice = timetable.premiumPrice,
                isStandardSold = timetable.isStandardSold,
                isPremiumSold = timetable.isPremiumSold,
                travelTime = timetable.travelTime
            )
        }
    )
}
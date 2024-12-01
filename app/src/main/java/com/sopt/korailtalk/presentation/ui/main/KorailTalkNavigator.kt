package com.sopt.korailtalk.presentation.ui.main

import androidx.navigation.NavController

fun NavController.navigateToTrainSearch() {
    navigate("train_search")
}

fun NavController.navigateToSeatMap(timetableId: Long) {
    navigate("seat_map/$timetableId")
}

fun NavController.navigateToTrainCheck(ticketId: Long) {
    navigate("train_check/$ticketId")
}

fun NavController.navigateToPayment(ticketId: Long) {
    navigate("payment/$ticketId")
}

fun NavController.navigateToMyTicket(ticketId: Long) {
    navigate("my_ticket/$ticketId")
}
package com.sopt.korailtalk.presentation.ui.main

import androidx.navigation.NavController

fun NavController.navigateToTrainSearch() {
    navigate("train_search")
}

fun NavController.navigateToSeatMap(
    timetableId: Long
) {
    navigate("seat_map/$timetableId")
}

fun NavController.navigateToTrainCheck(
    ticketId: Long
) {
    navigate("train_check/$ticketId")
}

fun NavController.navigateToPayment() {
    navigate("payment")
}

fun NavController.navigateToMyTicket() {
    navigate("my_ticket")
}
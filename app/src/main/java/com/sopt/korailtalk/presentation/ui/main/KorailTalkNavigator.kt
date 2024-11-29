package com.sopt.korailtalk.presentation.ui.main

import androidx.navigation.NavController

fun NavController.navigateToTrainSearch() {
    navigate("train_search")
}

fun NavController.navigateToSeatMap() {
    navigate("seat_map")
}

fun NavController.navigateToTrainCheck() {
    navigate("train_check")
}

fun NavController.navigateToPayment() {
    navigate("payment")
}

fun NavController.navigateToMyTicket() {
    navigate("my_ticket")
}
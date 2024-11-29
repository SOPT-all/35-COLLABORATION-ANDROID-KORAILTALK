package com.sopt.korailtalk.presentation.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sopt.korailtalk.presentation.ui.myticket.MyTicketScreen
import com.sopt.korailtalk.presentation.ui.payment.PaymentRoute
import com.sopt.korailtalk.presentation.ui.seatmap.SeatMapScreen
import com.sopt.korailtalk.presentation.ui.traincheck.TrainCheckScreen
import com.sopt.korailtalk.presentation.ui.trainsearch.TrainSearchScreen
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun KorailTalkNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = KorailTalkTheme.colors.white)
            .navigationBarsPadding()
            .statusBarsPadding()
    ) {
        NavHost(
            navController = navController,
            startDestination = "train_search"
        ) {
            composable(
                route = "train_search"
            ) {
                TrainSearchScreen(
                    navigateToSeatMap = { navController.navigateToSeatMap() },
                    navigateToTrainCheck = { navController.navigateToTrainCheck() }
                )
            }

            composable(
                route = "seat_map"
            ) {
                SeatMapScreen(
                    navigateToTrainCheck = { navController.navigateToTrainCheck() }
                )
            }

            composable(
                route = "train_check"
            ) {
                TrainCheckScreen(
                    navigateToPayment = { navController.navigateToPayment() }
                )
            }

            composable(
                route = "payment"
            ) {
                PaymentRoute(
                    navigateToMyTicket = { navController.navigateToMyTicket() }
                )
            }

            composable(
                route = "my_ticket"
            ) {
                MyTicketScreen()
            }
        }
    }
}
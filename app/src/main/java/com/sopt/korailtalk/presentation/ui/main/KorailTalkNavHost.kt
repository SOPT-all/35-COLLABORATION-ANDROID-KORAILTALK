package com.sopt.korailtalk.presentation.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
                    navigateToSeatMap = { timetableId -> navController.navigateToSeatMap(timetableId) },
                    navigateToTrainCheck = { ticketId -> navController.navigateToTrainCheck(ticketId) }
                )
            }

            composable(
                route = "seat_map/{timetableId}",
                arguments = listOf (
                    navArgument("timetableId") { type = NavType.LongType }
                )
            ) { backStackEntry ->
                val timetableId = backStackEntry.arguments?.getLong("timetableId") ?: 1
                SeatMapScreen(
                    timetableId = timetableId,
                    navigateToTrainCheck = { ticketId -> navController.navigateToTrainCheck(ticketId = ticketId) }
                )
            }

            composable(
                route = "train_check/{ticketId}",
                arguments = listOf(
                    navArgument("ticketId") { type = NavType.LongType }
                )
            ) { backStackEntry ->
                val ticketId = backStackEntry.arguments?.getLong("ticketId") ?: 32
                TrainCheckScreen(
                    ticketId = ticketId,
                    navigateToPayment = { navController.navigateToPayment(ticketId) }
                )
            }

            composable(
                route = "payment/{ticketId}",
                arguments = listOf(
                    navArgument("ticketId") { type = NavType.LongType }
                )
            ) { backStackEntry ->
                val ticketId = backStackEntry.arguments?.getLong("ticketId") ?: 32
                PaymentRoute(
                    ticketId = ticketId,
                    navigateToMyTicket = { navController.navigateToMyTicket(ticketId = ticketId) }
                )
            }

            composable(
                route = "my_ticket/{ticketId}",
                arguments = listOf(
                    navArgument("ticketId") { type = NavType.LongType }
                )
            ) { backStackEntry ->
                val ticketId = backStackEntry.arguments?.getLong("ticketId") ?: 32
                MyTicketScreen(
                    ticketId = ticketId
                )
            }
        }
    }
}
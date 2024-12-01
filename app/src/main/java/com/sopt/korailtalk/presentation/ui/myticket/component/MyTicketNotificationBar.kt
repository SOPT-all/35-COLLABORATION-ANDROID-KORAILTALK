package com.sopt.korailtalk.presentation.ui.myticket.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MyTicketNotificationBar() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Asset("and_korail.json")
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        clipSpec = LottieClipSpec.Frame(0, 370),
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.fillMaxWidth()
    )
}
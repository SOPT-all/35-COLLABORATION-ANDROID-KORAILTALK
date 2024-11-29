package com.sopt.korailtalk.presentation.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.sopt.korailtalk.presentation.util.roundedBackgroundWithBorder
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme

@Composable
fun CustomToast(
    msg: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = KorailTalkTheme.colors.transparentBlue95
            )
            .padding(horizontal = 10.dp, vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = msg,
            style = KorailTalkTheme.typography.title3.copy(
                color = KorailTalkTheme.colors.white
            )
        )
    }
}

class KorailToast(context: Context) : Toast(context) {
    @Composable
    fun ShowToast(
        msg: String,
        duration: Int = LENGTH_SHORT
    ) {
        val context = LocalContext.current
        val views = ComposeView(context)

        views.setContent {
            CustomToast(
                msg = msg
            )
        }

        views.setViewTreeLifecycleOwner(LocalLifecycleOwner.current)
        views.setViewTreeSavedStateRegistryOwner(LocalSavedStateRegistryOwner.current)
        views.setViewTreeViewModelStoreOwner(LocalViewModelStoreOwner.current)

        this.duration = duration
        this.view = views
        this.show()
    }
}

@Preview(showBackground = true)
@Composable
fun ShowKorailToast() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        CustomToast(
            msg = "승차권 상세정보를 로딩중입니다"
        )
    }
}
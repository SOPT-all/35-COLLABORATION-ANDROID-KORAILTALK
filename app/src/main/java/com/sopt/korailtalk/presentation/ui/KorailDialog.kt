package com.sopt.korailtalk.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography

@Composable
fun KorailDialog(
    title: String,
    content: @Composable () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = {},
    ) {
        Column(modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(color = KorailTalkTheme.colors.white)
        ){
            Text(text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(KorailTalkTheme.colors.blue07)
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                style = typography.body1
            )
            content()
            Text(
                text = stringResource(R.string.korailDialog_confirm),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(KorailTalkTheme.colors.blue03)
                    .clickable(onClick = onConfirm)
                    .padding(vertical = 17.dp),
                style = typography.body1,
                color = KorailTalkTheme.colors.white,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun KorailDialogPreview(){
    // 콘센트 확인인 경우
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        KorailDialog(
            title = stringResource(R.string.korailDialog_consentTitle),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(KorailTalkTheme.colors.white)
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.korailDialog_consentDescription),
                            style = typography.caption2,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.img_outlet),
                            contentDescription = "콘센트 사진",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.23f)
                        )
                    }
                }
            },
            onConfirm = { showDialog = false }
        )
    }
}
package com.sopt.korailtalk.presentation.ui.traincheck.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.sopt.korailtalk.R
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.KorailTalkTheme.typography

@Composable
fun TrainCheckDialogContent(){
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.trainCheck_dialog_notice),
            modifier = Modifier.padding(bottom = 8.dp),
            color = KorailTalkTheme.colors.red, style = typography.caption1
        )
        Text(
            text = stringResource(R.string.trainCheck_dialog_title),
            modifier = Modifier.padding(bottom = 8.dp),
            color = KorailTalkTheme.colors.grey800, style = typography.caption1
        )
        val items = listOf(
            stringResource(R.string.trainCheck_dialog_content_number_one) to buildAnnotatedString {
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                append(stringResource(R.string.trainCheck_dialog_content_first))
            } },
            stringResource(R.string.trainCheck_dialog_content_number_two) to buildAnnotatedString {
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                append(stringResource(R.string.trainCheck_dialog_content_second))
            } },
            stringResource(R.string.trainCheck_dialog_content_number_three) to  buildAnnotatedString {
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                    append(stringResource(R.string.trainCheck_dialog_content_third_start))
                }
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.red)) {
                    append(stringResource(R.string.trainCheck_dialog_content_third_highlight))
                }
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                    append(stringResource(R.string.trainCheck_dialog_content_third_end))
                }
            },
            stringResource(R.string.trainCheck_dialog_content_number_four) to buildAnnotatedString {
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                    append(stringResource(R.string.trainCheck_dialog_content_fourth))
                    append(" ")
                }
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.red)) {
                    append(stringResource(R.string.trainCheck_dialog_content_fourth_highlight))
                }
            },
            stringResource(R.string.trainCheck_dialog_content_number_five) to buildAnnotatedString {
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                append(stringResource(R.string.trainCheck_dialog_content_fifth))
            } },
            stringResource(R.string.trainCheck_dialog_content_number_six) to buildAnnotatedString {
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                append(stringResource(R.string.trainCheck_dialog_content_sixth))
            } },
            stringResource(R.string.trainCheck_dialog_content_number_seven) to buildAnnotatedString {
                withStyle(style = SpanStyle(color = KorailTalkTheme.colors.grey600)) {
                append(stringResource(R.string.trainCheck_dialog_content_seventh))
            } },
            )
        items.forEach { (number, text) ->
            TrainCheckDialogContentItem(number, text)
        }
        Row {
            Text(text = stringResource(R.string.trainCheck_dialog_content_number_eight),
                modifier = Modifier.padding(end = 4.dp, bottom = 4.dp),
                color = KorailTalkTheme.colors.grey600,
                style = typography.caption2)
            Text(text = stringResource(R.string.trainCheck_dialog_content_eighth),
                color = KorailTalkTheme.colors.grey600,
                style = typography.caption2
            )
        }
        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(
                text = stringResource(R.string.trainCheck_dialog_content_eighth_one),
                color = KorailTalkTheme.colors.grey600,
                style = typography.caption2
            )
            Text(
                text = stringResource(R.string.trainCheck_dialog_content_eighth_two),
                color = KorailTalkTheme.colors.grey600,
                style = typography.caption2
            )
        }
    }
}

@Composable
fun TrainCheckDialogContentItem(number: String, text: AnnotatedString) {
    Row {
        Text(
            text = number,
            modifier = Modifier.padding(bottom = 8.dp, end = 4.dp),
            color = KorailTalkTheme.colors.grey600,
            style = typography.caption2
        )
        Text(
            text = text,
            modifier = Modifier.padding(bottom = 8.dp),
            style = typography.caption2
        )
    }
}
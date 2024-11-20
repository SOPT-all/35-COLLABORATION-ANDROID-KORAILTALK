package com.sopt.korailtalk.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.korailtalk.ui.theme.KorailTalkTheme
import com.sopt.korailtalk.ui.theme.COLLAVORATIONANDROIDKORAILTALKTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            COLLAVORATIONANDROIDKORAILTALKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "코레일톡 기초세팅",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "$name!",
                style = KorailTalkTheme.typography.head1.copy(
                    color = KorailTalkTheme.colors.transparentBlue50
                ),
                modifier = modifier
            )
            Text(
                text = "$name!",
                style = KorailTalkTheme.typography.title1.copy(
                    color = KorailTalkTheme.colors.blue01
                ),
                modifier = modifier
            )
            Text(
                text = "$name!",
                style = KorailTalkTheme.typography.body3.copy(
                    color = KorailTalkTheme.colors.purple01
                ),
                modifier = modifier
            )
            Text(
                text = "$name!",
                style = KorailTalkTheme.typography.caption1.copy(
                    color = KorailTalkTheme.colors.grey600
                ),
                modifier = modifier
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    COLLAVORATIONANDROIDKORAILTALKTheme {
        Greeting("Android")
    }
}
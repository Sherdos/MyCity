package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.ui.theme.MyCityApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyCityApp() }
    }
}


@Preview(
    name = "App - Phone",
    showBackground = true,
    widthDp = 411,
    heightDp = 891
)
@Composable
fun AppPreviewPhone() {
    MyCityApp()
}
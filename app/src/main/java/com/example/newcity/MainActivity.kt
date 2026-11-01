package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier

enum class MyCityContentType { LIST_ONLY, LIST_AND_DETAIL }

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val windowSize = calculateWindowSizeClass(this)
                    val contentType = when (windowSize.widthSizeClass) {
                        WindowWidthSizeClass.Expanded -> MyCityContentType.LIST_AND_DETAIL
                        else -> MyCityContentType.LIST_ONLY
                    }
                    MyCityApp(contentType = contentType)
                }
            }
        }
    }
}
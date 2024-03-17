package com.example.canvasworkshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.dp
import com.example.canvasworkshop.screens.animating_path.AnimatingAPathArrowScreen
import com.example.canvasworkshop.screens.animating_path.AnimatingAPathLineScreen
import com.example.canvasworkshop.screens.common.AppToolbar
import com.example.canvasworkshop.screens.selector.SelectorScreen
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasWorkshopTheme {
                CanvasWorkshopApp()
            }
        }
    }
}

@Composable
fun CanvasWorkshopApp() {
    CanvasWorkshopTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var selectedScreen by remember {
                mutableStateOf<Screens>(Screens.Selector)
            }
            when (selectedScreen) {
                Screens.Selector -> {
                    SelectorScreen { selectedScreen = it }
                }

                Screens.AnimatingAPathArrow -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    AnimatingAPathArrowScreen()
                }

                Screens.AnimatingAPathLine -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    AnimatingAPathLineScreen()
                }
            }
        }
    }
}

@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun CinemaAppPreview() {
    CanvasWorkshopApp()
}
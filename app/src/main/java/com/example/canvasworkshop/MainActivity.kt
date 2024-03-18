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
import com.example.canvasworkshop.screens.common.AppToolbar
import com.example.canvasworkshop.screens.detecting_touch.DetectingTouchScreen
import com.example.canvasworkshop.screens.drawing.DrawingImagesAndBlendModesScreen
import com.example.canvasworkshop.screens.drawing.DrawingTextScreen
import com.example.canvasworkshop.screens.gender_picker.GenderPickerScreen
import com.example.canvasworkshop.screens.path.*
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

                Screens.DetectingTouch -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    DetectingTouchScreen()
                }

                Screens.DrawingImagesAndBlendModes -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    DrawingImagesAndBlendModesScreen()
                }

                Screens.DrawingText -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    DrawingTextScreen()
                }

                Screens.GenderPicker -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    GenderPickerScreen() {}
                }

                Screens.PathBasics -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    PathBasicsScreen()
                }

                Screens.PathDemonstration -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    PathDemonstrationScreen()
                }

                Screens.PathEffects -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    PathEffectsScreen()
                }

                Screens.PathOperations -> Column {
                    AppToolbar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        selectedScreen = selectedScreen,
                    ) { selectedScreen = it }
                    PathOperationsScreen()
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
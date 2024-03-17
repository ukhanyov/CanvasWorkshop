package com.example.canvasworkshop

sealed class Screens(val name: String) {
    data object Selector : Screens("Selector")
    data object AnimatingAPathArrow : Screens("Animating a Path Arrow")
    data object AnimatingAPathLine : Screens("Animating a Path Line")
    data object DetectingTouch : Screens("Detecting Touch")
    data object DrawingImagesAndBlendModes : Screens("Drawing Images and BlendModes")
}

val majorScreens = listOf<Screens>()
val minorScreens = listOf(
    Screens.AnimatingAPathArrow,
    Screens.AnimatingAPathLine,
    Screens.DetectingTouch,
    Screens.DrawingImagesAndBlendModes,
)
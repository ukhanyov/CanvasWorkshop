package com.example.canvasworkshop

sealed class Screens(val name: String) {
    data object Selector : Screens("Selector")
    data object AnimatingAPathArrow : Screens("Animating a Path Arrow")
    data object AnimatingAPathLine : Screens("Animating a Path Line")
    data object DetectingTouch : Screens("Detecting Touch on screen")
}

val majorScreens = listOf<Screens>()
val minorScreens = listOf(
    Screens.AnimatingAPathArrow,
    Screens.AnimatingAPathLine,
    Screens.DetectingTouch,
)
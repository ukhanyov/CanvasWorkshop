package com.example.canvasworkshop

sealed class Screens(val name: String) {
    data object Selector : Screens("Selector")
    data object AnimatingAPathArrow : Screens("Animating a Path Arrow")
    data object AnimatingAPathLine : Screens("Animating a Path Line")
}

val majorScreens = listOf<Screens>()
val minorScreens = listOf(
    Screens.AnimatingAPathArrow,
    Screens.AnimatingAPathLine,
)
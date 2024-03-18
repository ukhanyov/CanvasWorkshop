package com.example.canvasworkshop

sealed class Screens(val name: String) {
    data object Selector : Screens("Selector")
    data object AnimatingAPathArrow : Screens("Animating a Path Arrow")
    data object AnimatingAPathLine : Screens("Animating a Path Line")
    data object DetectingTouch : Screens("Detecting Touch")
    data object DrawingImagesAndBlendModes : Screens("Drawing Images and BlendModes")
    data object DrawingText : Screens("Drawing Text")
    data object GenderPicker : Screens("Gender Picker")
    data object PathBasics : Screens("Path Basics")
}

val majorScreens = listOf<Screens>(
    Screens.GenderPicker
)
val minorScreens = listOf(
    Screens.AnimatingAPathArrow,
    Screens.AnimatingAPathLine,
    Screens.DetectingTouch,
    Screens.DrawingImagesAndBlendModes,
    Screens.DrawingText,
    Screens.PathBasics,
)
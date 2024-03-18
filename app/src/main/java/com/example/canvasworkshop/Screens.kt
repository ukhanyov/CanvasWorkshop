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
    data object PathDemonstration : Screens("Path Demonstration")
    data object PathEffects : Screens("Path Effects")
    data object PathOperations : Screens("Path Operations")
    data object SimpleCanvasShapes : Screens("Simple Canvas Shapes")
    data object TransformationsAndClipping : Screens("Transformations and Clipping")
    data object WeightPicker : Screens("Weight Picker")
    data object WritingTextOnAPath : Screens("Writing Text on a Path")
    data object Clock : Screens("Clock")
}

val majorScreens = listOf(
    Screens.GenderPicker,
    Screens.WeightPicker,
    Screens.Clock,
)
val minorScreens = listOf(
    Screens.AnimatingAPathArrow,
    Screens.AnimatingAPathLine,
    Screens.DetectingTouch,
    Screens.DrawingImagesAndBlendModes,
    Screens.DrawingText,
    Screens.PathBasics,
    Screens.PathDemonstration,
    Screens.PathEffects,
    Screens.PathOperations,
    Screens.SimpleCanvasShapes,
    Screens.TransformationsAndClipping,
    Screens.WritingTextOnAPath,
)
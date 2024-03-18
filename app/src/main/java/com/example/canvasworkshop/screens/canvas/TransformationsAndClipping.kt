package com.example.canvasworkshop.screens.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.dp
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme

@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun TransformationsAndClippingPreview() {
    CanvasWorkshopTheme {
        TransformationsAndClippingScreen()
    }
}

@Composable
fun TransformationsAndClippingScreen() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val circle = Path().apply {
            addOval(Rect(center = Offset(400f, 400f), radius = 300f))
        }
        drawPath(
            path = circle,
            color = Color.Black,
            style = Stroke(width = 5.dp.toPx())
        )
        clipPath(path = circle) {
//        scale(0.5f, pivot = Offset(200f, 200f)) {
//        translate(left = 300f, top = 300f) {
//        rotate(45f, pivot = Offset(200f, 200f)) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(100f, 100f),
                size = Size(200f, 200f)
            )
        }
    }
}
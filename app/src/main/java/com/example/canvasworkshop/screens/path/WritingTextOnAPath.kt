package com.example.canvasworkshop.screens.path

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.*
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme

@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun WritingTextOnAPathScreenPreview() {
    CanvasWorkshopTheme {
        WritingTextOnAPathScreen()
    }
}

@Composable
fun WritingTextOnAPathScreen() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = android.graphics.Path().apply {
            moveTo(200f, 800f)
            quadTo(600f, 400f, 1000f, 800f)
        }
        drawContext.canvas.nativeCanvas.apply {
            drawTextOnPath(
                "Hello world",
                path,
                30f,
                50f,
                android.graphics.Paint().apply {
                    color = android.graphics.Color.RED
                    textSize = 70f
                    textAlign = android.graphics.Paint.Align.CENTER
                }
            )
        }
    }
}
package com.example.canvasworkshop.screens.drawing

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme

@Preview(showBackground = true)
@Composable
fun DrawingTextScreenPreview() {
    CanvasWorkshopTheme {
        DrawingTextScreen()
    }
}

@Composable
fun DrawingTextScreen() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        drawContext.canvas.nativeCanvas.apply {
            drawText(
                "This is canvas text",
                100f,
                100f,
                Paint().apply { // for Paint and everything inside paint use old android imports
                    color = Color.RED
                    textSize = 100f
                }
            )
        }
    }
}
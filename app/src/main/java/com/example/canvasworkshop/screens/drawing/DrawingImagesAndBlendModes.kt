package com.example.canvasworkshop.screens.drawing

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.example.canvasworkshop.R
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme

@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun DrawingImagesAndBlendModesScreenPreview() {
    CanvasWorkshopTheme {
        DrawingImagesAndBlendModesScreen()
    }
}

@Composable
fun DrawingImagesAndBlendModesScreen() {
    val stockImage = ImageBitmap.imageResource(id = R.drawable.stock_image)
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawImage(
            image = stockImage,
            dstOffset = IntOffset(100, 100),
            dstSize = IntSize(
                (400 * (stockImage.width.toFloat() / stockImage.height)).toInt(),
                400
            )
        )
        drawCircle(
            color = Color.Cyan,
            radius = 200f,
            center = Offset(200f, 200f),
            blendMode = BlendMode.Color
        )
    }
}
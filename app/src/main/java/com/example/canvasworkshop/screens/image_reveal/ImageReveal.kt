package com.example.canvasworkshop.screens.image_reveal

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.example.canvasworkshop.R
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme
import kotlin.math.roundToInt

@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun HomeWork3PhilipScreenPreview() {
    CanvasWorkshopTheme {
        ImageRevealScreen()
    }
}

@Composable
fun ImageRevealScreen() {
    var circlePos by remember { mutableStateOf(Offset.Zero) }
    var oldCirclePos by remember { mutableStateOf(Offset.Zero) }

    val imageBmp = ImageBitmap.imageResource(id = R.drawable.stock_image)
    val radius = 200f

    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInput(true) {
            detectDragGestures(
                onDragEnd = {
                    oldCirclePos = circlePos
                }
            ) { change, _ ->
                circlePos = oldCirclePos + change.position
            }
        }
    ) {
        val bmpHeight =
            ((imageBmp.height.toFloat() / imageBmp.width.toFloat()) * size.width).roundToInt()
        val circlePath = Path().apply {
            addArc(
                oval = Rect(circlePos, radius),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 360f
            )
        }
        drawImage(
            image = imageBmp,
            dstSize = IntSize(size.width.roundToInt(), bmpHeight),
            dstOffset = IntOffset(0, center.y.roundToInt() - bmpHeight / 2),
            colorFilter = ColorFilter.tint(Color.Black, BlendMode.Color)
        )
        clipPath(circlePath, clipOp = ClipOp.Intersect) {
            drawImage(
                image = imageBmp,
                dstSize = IntSize(size.width.roundToInt(), bmpHeight),
                dstOffset = IntOffset(0, center.y.roundToInt() - bmpHeight / 2),
            )
        }
    }
}
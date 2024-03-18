package com.example.canvasworkshop.screens.path

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.dp
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme

@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun PathBasicsScreenPreview() {
    CanvasWorkshopTheme {
        PathBasicsScreen()
    }
}

@Composable
fun PathBasicsScreen() {
//    Canvas(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        val path = Path().apply {
//            moveTo(100f, 100f)
//            lineTo(100f, 500f)
//            lineTo(500f, 500f)
//            lineTo(500f, 100f)
//            lineTo(100f, 100f)
//        }
//        drawPath(
//            path = path,
//            color = Color.Red,
//            style = Stroke(width = 5.dp.toPx())
//        )
//    }
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val path = Path().apply {
            moveTo(100f, 100f)
            lineTo(100f, 500f)
            lineTo(500f, 500f)
//            quadraticBezierTo(
//                800f,
//                300f,
//                500f,
//                100f,
//            )
            cubicTo(
                800f,
                500f,
                800f,
                100f,
                500f,
                100f,
            )
            close()
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )
    }
}
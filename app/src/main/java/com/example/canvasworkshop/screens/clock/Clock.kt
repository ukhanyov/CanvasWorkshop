package com.example.canvasworkshop.screens.clock

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme
import kotlinx.coroutines.delay
import java.time.ZonedDateTime
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

data class ClockStyle(
    val radius: Dp = 100.dp,
    val hourLineLength: Dp = 16.dp,
    val minuteLineLength: Dp = 8.dp,
    val hourLineColor: Color = Color.Black,
    val minuteLineColor: Color = Color.LightGray,
    val secondsPointerColor: Color = Color.Red,
    val minutesPointerColor: Color = Color.Black,
)

sealed class ClockLine {
    data object HourLine : ClockLine()
    data object MinuteLine : ClockLine()
}


@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun ClockScreenPreview() {
    CanvasWorkshopTheme {
        ClockScreen()
    }
}

@Composable
fun ClockScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val dateTime = ZonedDateTime.now()
        var seconds by remember { mutableIntStateOf(dateTime.second) }
        var minutes by remember { mutableIntStateOf(dateTime.minute) }
        var hours by remember { mutableIntStateOf(dateTime.hour) }

        LaunchedEffect(key1 = seconds) {
            delay(1000L)
            val newDateTime = ZonedDateTime.now()
            seconds = newDateTime.second
            minutes = newDateTime.minute
            hours = newDateTime.hour
        }

        Clock(seconds = seconds, minutes = minutes, hours = hours)
    }
}

@Composable
fun Clock(
    style: ClockStyle = ClockStyle(),
    seconds: Int,
    minutes: Int,
    hours: Int,
) {
    var center by remember { mutableStateOf(Offset.Zero) }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        center = this.center

        // draw clock background
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                center.x,
                center.y,
                style.radius.toPx(),
                Paint().apply {
                    strokeWidth = style.radius.toPx()
                    color = android.graphics.Color.WHITE
                    setStyle(Paint.Style.FILL)
                    setShadowLayer(
                        60f,
                        0f,
                        0f,
                        android.graphics.Color.argb(50, 0, 0, 0)
                    )
                }
            )
        }

        // Draw clock lines
        for (i in 1..60) {
            val angleInRad = (i * 6) * (PI / 180f).toFloat()
            val lineType = when {
                i % 5 == 0 -> ClockLine.HourLine
                else -> ClockLine.MinuteLine
            }
            val lineColor = when (lineType) {
                ClockLine.HourLine -> style.hourLineColor
                ClockLine.MinuteLine -> style.minuteLineColor
            }
            val lineLength = when (lineType) {
                ClockLine.HourLine -> style.hourLineLength.toPx()
                ClockLine.MinuteLine -> style.minuteLineLength.toPx()
            }
            val lineStart = Offset(
                x = (style.radius.toPx() - lineLength) * cos(angleInRad) + center.x,
                y = (style.radius.toPx() - lineLength) * sin(angleInRad) + center.y
            )
            val lineEnd = Offset(
                x = style.radius.toPx() * cos(angleInRad) + center.x,
                y = style.radius.toPx() * sin(angleInRad) + center.y
            )
            drawLine(
                color = lineColor,
                start = lineStart,
                end = lineEnd,
                strokeWidth = 2.dp.toPx()
            )
        }

        // draw seconds
        Unit.let {
            val angleInRad = (seconds * 6 - 90) * (PI / 180f).toFloat()
            drawLine(
                color = style.secondsPointerColor,
                start = Offset(
                    x = cos(angleInRad) + center.x,
                    y = sin(angleInRad) + center.y
                ),
                end = Offset(
                    x = (style.radius.toPx() - style.hourLineLength.toPx()) * cos(angleInRad) + center.x,
                    y = (style.radius.toPx() - style.hourLineLength.toPx()) * sin(angleInRad) + center.y
                ),
                strokeWidth = 2.dp.toPx(),
                cap = StrokeCap.Round
            )
        }

        // draw seconds
        Unit.let {
            val angleInRad = (minutes * 6 - 90) * (PI / 180f).toFloat()
            drawLine(
                color = style.minutesPointerColor,
                start = Offset(
                    x = cos(angleInRad) + center.x,
                    y = sin(angleInRad) + center.y
                ),
                end = Offset(
                    x = (style.radius.toPx() - style.hourLineLength.toPx()) * cos(angleInRad) + center.x,
                    y = (style.radius.toPx() - style.hourLineLength.toPx()) * sin(angleInRad) + center.y
                ),
                strokeWidth = 3.dp.toPx(),
                cap = StrokeCap.Round
            )
        }

        // draw hours
        Unit.let {
            val angleInRad = (hours * 30 + (minutes / 2) - 90) * (PI / 180f).toFloat()
            drawLine(
                color = style.minutesPointerColor,
                start = Offset(
                    x = cos(angleInRad) + center.x,
                    y = sin(angleInRad) + center.y
                ),
                end = Offset(
                    x = (style.radius.toPx() - style.hourLineLength.toPx() * 2) * cos(angleInRad) + center.x,
                    y = (style.radius.toPx() - style.hourLineLength.toPx() * 2) * sin(angleInRad) + center.y
                ),
                strokeWidth = 4.dp.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}
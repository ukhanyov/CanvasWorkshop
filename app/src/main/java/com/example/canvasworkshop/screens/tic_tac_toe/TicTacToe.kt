package com.example.canvasworkshop.screens.tic_tac_toe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme
import kotlinx.coroutines.delay

data class GameState(
    val topLeft: GamePlayer? = null,
    val topCenter: GamePlayer? = null,
    val topRight: GamePlayer? = null,
    val centerLeft: GamePlayer? = null,
    val center: GamePlayer? = null,
    val centerRight: GamePlayer? = null,
    val bottomLeft: GamePlayer? = null,
    val bottomCenter: GamePlayer? = null,
    val bottomRight: GamePlayer? = null,
    val gameResult: GameResult = GameResult.Running
)

sealed class GamePlayer {
    data object One : GamePlayer()
    data object Two : GamePlayer()
}

sealed class GameResult {
    data object Running : GameResult()
    data object PlayerOneWon : GameResult()
    data object PlayerTwoWon : GameResult()
    data object Tie : GameResult()
}

@Preview(showBackground = true)
@Composable
fun TicTacToeScreenPreview() {
    CanvasWorkshopTheme {
        TicTacToeScreen()
    }
}

@Composable
fun TicTacToeScreen() {
    TicTacToe()
}

@Composable
fun TicTacToe(
    lineWidth: Dp = 5.dp,
//    isGameRunning: Boolean = true
) {
    var topLeftRect by remember { mutableStateOf(Rect.Zero) }
    var topCenterRect by remember { mutableStateOf(Rect.Zero) }
    var topRightRect by remember { mutableStateOf(Rect.Zero) }

    var centerLeftRect by remember { mutableStateOf(Rect.Zero) }
    var centerRect by remember { mutableStateOf(Rect.Zero) }
    var centerRightRect by remember { mutableStateOf(Rect.Zero) }

    var bottomLeftRect by remember { mutableStateOf(Rect.Zero) }
    var bottomCenterRect by remember { mutableStateOf(Rect.Zero) }
    var bottomRightRect by remember { mutableStateOf(Rect.Zero) }

    var gameState by remember { mutableStateOf(GameState()) }

    var gamePlayerTurn by remember { mutableStateOf<GamePlayer>(GamePlayer.One) }

    val isGameRunning by remember(gameState) { mutableStateOf(gameState.gameResult is GameResult.Running) }

    LaunchedEffect(key1 = isGameRunning) {
        if (isGameRunning.not()) {
            delay(2500)
            gameState = GameState()
            gamePlayerTurn = GamePlayer.One
        }
    }

    fun togglePlayer() {
        gamePlayerTurn = if (gamePlayerTurn is GamePlayer.One) {
            GamePlayer.Two
        } else {
            GamePlayer.One
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = when (gameState.gameResult) {
                GameResult.PlayerOneWon -> "Player One Won!"
                GameResult.PlayerTwoWon -> "Player Two Won!"
                GameResult.Running -> "Player ${if (gamePlayerTurn is GamePlayer.One) "one" else "two"} turn"
                GameResult.Tie -> "Tie!"
            },
            modifier = Modifier.padding(32.dp)
        )
        Canvas(
            modifier = Modifier
                .size(300.dp)
                .pointerInput(isGameRunning) {
                    if (isGameRunning.not()) return@pointerInput
                    detectTapGestures {
                        when {
                            topLeftRect.contains(it) && gameState.topLeft == null -> {
                                gameState = gameState.copy(topLeft = gamePlayerTurn)
                                togglePlayer()
                            }

                            topCenterRect.contains(it) && gameState.topCenter == null -> {
                                gameState = gameState.copy(topCenter = gamePlayerTurn)
                                togglePlayer()
                            }

                            topRightRect.contains(it) && gameState.topRight == null -> {
                                gameState = gameState.copy(topRight = gamePlayerTurn)
                                togglePlayer()
                            }

                            centerLeftRect.contains(it) && gameState.centerLeft == null -> {
                                gameState = gameState.copy(centerLeft = gamePlayerTurn)
                                togglePlayer()
                            }

                            centerRect.contains(it) && gameState.center == null -> {
                                gameState = gameState.copy(center = gamePlayerTurn)
                                togglePlayer()
                            }

                            centerRightRect.contains(it) && gameState.centerRight == null -> {
                                gameState = gameState.copy(centerRight = gamePlayerTurn)
                                togglePlayer()
                            }

                            bottomLeftRect.contains(it) && gameState.bottomLeft == null -> {
                                gameState = gameState.copy(bottomLeft = gamePlayerTurn)
                                togglePlayer()
                            }

                            bottomCenterRect.contains(it) && gameState.bottomCenter == null -> {
                                gameState = gameState.copy(bottomCenter = gamePlayerTurn)
                                togglePlayer()
                            }

                            bottomRightRect.contains(it) && gameState.bottomRight == null -> {
                                gameState = gameState.copy(bottomRight = gamePlayerTurn)
                                togglePlayer()
                            }
                        }
                    }
                }
        ) {
            gameState = gameState.copy(gameResult = gameState.check())
            val rectSize = Size(size.width / 3f, size.width / 3f)

            if (topLeftRect == Rect.Zero) {
                topLeftRect = Rect(
                    offset = Offset(0f, 0f),
                    size = rectSize
                )
            }
            if (topCenterRect == Rect.Zero) {
                topCenterRect = Rect(
                    offset = Offset(size.width / 3, 0f),
                    size = rectSize
                )
            }
            if (topRightRect == Rect.Zero) {
                topRightRect = Rect(
                    offset = Offset(size.width / 3 * 2, 0f),
                    size = rectSize
                )
            }
            if (centerLeftRect == Rect.Zero) {
                centerLeftRect = Rect(
                    offset = Offset(0f, size.height / 3),
                    size = rectSize
                )
            }
            if (centerRect == Rect.Zero) {
                centerRect = Rect(
                    offset = Offset(size.width / 3, size.height / 3),
                    size = rectSize
                )
            }
            if (centerRightRect == Rect.Zero) {
                centerRightRect = Rect(
                    offset = Offset(size.width / 3 * 2, size.height / 3),
                    size = rectSize
                )
            }
            if (bottomLeftRect == Rect.Zero) {
                bottomLeftRect = Rect(
                    offset = Offset(0f, size.height / 3 * 2),
                    size = rectSize
                )
            }
            if (bottomCenterRect == Rect.Zero) {
                bottomCenterRect = Rect(
                    offset = Offset(size.width / 3, size.height / 3 * 2),
                    size = rectSize
                )
            }
            if (bottomRightRect == Rect.Zero) {
                bottomRightRect = Rect(
                    offset = Offset(size.width / 3 * 2, size.height / 3 * 2),
                    size = rectSize
                )
            }

            // Draw figures
            drawFigure(gameState.topLeft, topLeftRect, rectSize)
            drawFigure(gameState.topCenter, topCenterRect, rectSize)
            drawFigure(gameState.topRight, topRightRect, rectSize)
            drawFigure(gameState.centerLeft, centerLeftRect, rectSize)
            drawFigure(gameState.center, centerRect, rectSize)
            drawFigure(gameState.centerRight, centerRightRect, rectSize)
            drawFigure(gameState.bottomLeft, bottomLeftRect, rectSize)
            drawFigure(gameState.bottomCenter, bottomCenterRect, rectSize)
            drawFigure(gameState.bottomRight, bottomRightRect, rectSize)

            // game field
            drawLine(
                color = Color.Black,
                start = Offset(size.width / 3, 0f),
                end = Offset(size.width / 3, size.height),
                strokeWidth = lineWidth.toPx(),
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Black,
                start = Offset(size.width / 3 * 2, 0f),
                end = Offset(size.width / 3 * 2, size.height),
                strokeWidth = lineWidth.toPx(),
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Black,
                start = Offset(0f, size.height / 3),
                end = Offset(size.width, size.height / 3),
                strokeWidth = lineWidth.toPx(),
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color.Black,
                start = Offset(0f, size.height / 3 * 2),
                end = Offset(size.width, size.height / 3 * 2),
                strokeWidth = lineWidth.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}

private fun DrawScope.drawFigure(
    gamePlayer: GamePlayer?,
    rect: Rect,
    rectSize: Size
) {
    when (gamePlayer) {
        GamePlayer.One -> {
            drawLine(
                color = gamePlayer.getColor(),
                start = rect.topRight.let { Offset(it.x - 25.dp.toPx(), it.y + 25.dp.toPx()) },
                end = rect.bottomLeft.let { Offset(it.x + 25.dp.toPx(), it.y - 25.dp.toPx()) },
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Round
            )
            drawLine(
                color = gamePlayer.getColor(),
                start = rect.topLeft.let { Offset(it.x + 25.dp.toPx(), it.y + 25.dp.toPx()) },
                end = rect.bottomRight.let { Offset(it.x - 25.dp.toPx(), it.y - 25.dp.toPx()) },
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Round
            )
        }

        GamePlayer.Two -> {
            drawOval(
                color = gamePlayer.getColor(),
                topLeft = rect.topLeft.let { Offset(it.x + 25.dp.toPx(), it.y + 25.dp.toPx()) },
                size = rectSize.let { Size(it.width - 50.dp.toPx(), it.height - 50.dp.toPx()) },
                style = Stroke(width = 5.dp.toPx())
            )
        }

        null -> {
        }
    }
}

private fun GamePlayer.getColor() = when (this) {
    GamePlayer.One -> Color.Blue
    GamePlayer.Two -> Color.Red
}

private fun GameState.check(): GameResult {
    val row1 = listOf(this.topLeft, this.topCenter, this.topRight)
    val row2 = listOf(this.centerLeft, this.center, this.centerRight)
    val row3 = listOf(this.bottomLeft, this.bottomCenter, this.bottomRight)
    val column1 = listOf(this.topLeft, this.centerLeft, this.bottomLeft)
    val column2 = listOf(this.topCenter, this.center, this.bottomCenter)
    val column3 = listOf(this.topRight, this.centerRight, this.bottomRight)
    val diagonal1 = listOf(this.topLeft, this.center, this.bottomRight)
    val diagonal2 = listOf(this.topRight, this.center, this.bottomLeft)

    return when {
        row1.all { it is GamePlayer.One } -> GameResult.PlayerOneWon
        row2.all { it is GamePlayer.One } -> GameResult.PlayerOneWon
        row3.all { it is GamePlayer.One } -> GameResult.PlayerOneWon
        column1.all { it is GamePlayer.One } -> GameResult.PlayerOneWon
        column2.all { it is GamePlayer.One } -> GameResult.PlayerOneWon
        column3.all { it is GamePlayer.One } -> GameResult.PlayerOneWon
        diagonal1.all { it is GamePlayer.One } -> GameResult.PlayerOneWon
        diagonal2.all { it is GamePlayer.One } -> GameResult.PlayerOneWon

        row1.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon
        row2.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon
        row3.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon
        column1.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon
        column2.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon
        column3.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon
        diagonal1.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon
        diagonal2.all { it is GamePlayer.Two } -> GameResult.PlayerTwoWon

        this.topLeft != null && this.topCenter != null && this.topRight != null &&
                this.centerLeft != null && this.center != null && this.centerRight != null &&
                this.bottomLeft != null && this.bottomCenter != null && this.bottomRight != null -> GameResult.Tie

        else -> GameResult.Running
    }
}
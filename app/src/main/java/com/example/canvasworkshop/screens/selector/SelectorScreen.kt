package com.example.canvasworkshop.screens.selector

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvasworkshop.Screens
import com.example.canvasworkshop.ui.theme.CanvasWorkshopTheme

@Preview
@PreviewScreenSizes
@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
fun SelectorScreenPreview() {
    CanvasWorkshopTheme {
        SelectorScreen()
    }
}

@Composable
fun SelectorScreen(
    onScreenSelected: (Screens) -> Unit = {},
) {
    val listState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(listState)
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = "Major",
            fontSize = 20.sp,
        )
        majorScreens.forEach {
            Text(
                text = it.name,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable { onScreenSelected(it) }
            )
        }
        HorizontalDivider()
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = "Minor",
            fontSize = 20.sp,
        )
        minorScreens.forEach {
            Text(
                text = it.name,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable { onScreenSelected(it) }
            )
        }
    }
}

val majorScreens = listOf<Screens>()
val minorScreens = listOf<Screens>(
    Screens.AnimatingAPathArrow
)
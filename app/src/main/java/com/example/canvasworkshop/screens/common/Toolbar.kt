package com.example.canvasworkshop.screens.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.dp
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
        Toolbar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    selectedScreen: Screens = Screens.Selector,
    onBackClicked: (Screens) -> Unit = {}
) {
    Row(modifier = modifier) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .defaultMinSize(minHeight = 25.dp, minWidth = 25.dp)
                .clickable {
                    if (selectedScreen != Screens.Selector)
                        onBackClicked(Screens.Selector)
                }
        )
        if (selectedScreen != Screens.Selector)
            Text(
                text = "Go Back to lessons selection",
                modifier = Modifier
                    .padding(start = 8.dp)
            )
    }
}
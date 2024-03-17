package com.example.canvasworkshop

sealed class Screens(val name: String) {
    data object Selector : Screens("Selector")
    data object AnimatingAPathArrow : Screens("Animating an Arrow Path")
}
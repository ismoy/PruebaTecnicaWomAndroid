package com.github.comismoy.pruebatecnicawomandroid.ui.core.navigation

sealed class ScreenRoutes(val screenRoutes:String) {

    data object Home : ScreenRoutes("home")
}
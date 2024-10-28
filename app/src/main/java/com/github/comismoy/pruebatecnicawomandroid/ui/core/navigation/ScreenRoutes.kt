package com.github.comismoy.pruebatecnicawomandroid.ui.core.navigation

import com.github.comismoy.pruebatecnicawomandroid.ui.core.utils.Constants.DETAILS_SCREEN
import com.github.comismoy.pruebatecnicawomandroid.ui.core.utils.Constants.HOME_SCREEN


sealed class ScreenRoutes(val screenRoutes:String) {

    data object Home : ScreenRoutes(HOME_SCREEN)

    data object Details :ScreenRoutes("$DETAILS_SCREEN/{breedName}"){
        fun createRoute(breedName:String) = "$DETAILS_SCREEN/$breedName"
    }
}
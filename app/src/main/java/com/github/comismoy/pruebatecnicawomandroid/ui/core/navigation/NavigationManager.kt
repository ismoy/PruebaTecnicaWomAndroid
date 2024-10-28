package com.github.comismoy.pruebatecnicawomandroid.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.comismoy.pruebatecnicawomandroid.ui.home.HomeScreen

@Composable
fun NavigationManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.Home.screenRoutes ) {

        composable(ScreenRoutes.Home.screenRoutes){
            HomeScreen(navController)
        }
    }
}
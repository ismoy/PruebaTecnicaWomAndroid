package com.github.comismoy.pruebatecnicawomandroid.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.comismoy.pruebatecnicawomandroid.ui.details.DetailsScreen
import com.github.comismoy.pruebatecnicawomandroid.ui.home.HomeScreen

@Composable
fun NavigationManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.Home.screenRoutes ) {

        composable(ScreenRoutes.Home.screenRoutes){
            HomeScreen(navController)
        }

        composable(
            route = ScreenRoutes.Details.screenRoutes,
            arguments = listOf(navArgument("breedName"){type = NavType.StringType})
        ) {  backStackEntry->
            val breedName = backStackEntry.arguments?.getString("breedName")?:""
            DetailsScreen(navController,breedName = breedName)
        }
    }
}
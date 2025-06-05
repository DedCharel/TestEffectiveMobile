package ru.nvgsoft.testeffectivemobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    vacancyScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    responseScreenContent: @Composable () -> Unit,
    messageScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
){
    NavHost(
        navController = navHostController ,
        startDestination = Screen.Vacancy.route
    ){
        composable(Screen.Vacancy.route) {
            vacancyScreenContent()
        }
        composable(Screen.Favorite.route){
            favouriteScreenContent()
        }
        composable(Screen.Response.route){
            responseScreenContent()
        }
        composable(Screen.Message.route){
            messageScreenContent()
        }
        composable(Screen.Profile.route){
            profileScreenContent()
        }

    }

}
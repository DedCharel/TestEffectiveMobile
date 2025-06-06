package ru.nvgsoft.testeffectivemobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeScreenNavGraph(
    vacancyScreenContent: @Composable () -> Unit,
    vacancyDetailScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.Vacancy.route,
        route = Screen.Home.route
    ){
        composable(Screen.Vacancy.route){
            vacancyScreenContent()
        }
        composable(Screen.VacancyDetail.route)
        {

            vacancyDetailScreenContent()
        }

    }
}
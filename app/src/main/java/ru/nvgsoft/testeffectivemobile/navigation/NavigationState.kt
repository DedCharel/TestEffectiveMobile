package ru.nvgsoft.testeffectivemobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

class NavigationState (
    val navHostController: NavHostController
){
    fun navigateTo(rout: String){
        navHostController.navigate(rout) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToDetail(vacancy: VacancyModel){
        navHostController.navigate(Screen.VacancyDetail.getRouteWithArgs(vacancy))
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState{
    return remember {
        NavigationState(navHostController)
    }
}
package ru.nvgsoft.testeffectivemobile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.navigation.AppNavGraph
import ru.nvgsoft.testeffectivemobile.navigation.rememberNavigationState
import ru.nvgsoft.testeffectivemobile.presentation.favourite.FavoriteScreen
import ru.nvgsoft.testeffectivemobile.presentation.message.MessageScreen
import ru.nvgsoft.testeffectivemobile.presentation.profile.ProfileScreen
import ru.nvgsoft.testeffectivemobile.presentation.response.ResponseScreen
import ru.nvgsoft.testeffectivemobile.presentation.vacancy.VacancyScreen
import ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail.VacancyDetailScreen


@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    //временное решение , вакансию надо передавать при навигации если будет время переделаю
    val vacancy: MutableState<VacancyEntity?> = remember {
        mutableStateOf(null)
    }

    Scaffold(bottomBar =
    {
        NavigationBar(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .padding(top = 1.dp),
            containerColor = MaterialTheme.colorScheme.background
        ) {

            
            val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
            val items = listOf(
                NavigationItem.Find,
                NavigationItem.Favorites,
                NavigationItem.Responses,
                NavigationItem.Message,
                NavigationItem.Profile
            )
            items.forEach { item ->
                val selected = navBackStackEntry?.destination?.hierarchy?.any{
                    it.route == item.screen.route
                } ?: false
                NavigationBarItem(

                    selected = selected,
                    onClick = {
                        if (!selected) {
                            navigationState.navigateTo(item.screen.route)
                        }
                    },
                    icon = {
                        Icon(painterResource(id = item.icon), contentDescription = null)
                    },
                    label = {
                        Text(text = stringResource(id = item.titleResId), fontSize = 11.sp)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        indicatorColor = MaterialTheme.colorScheme.background
                    )

                )
            }
        }
    }) { padding ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            vacancyScreenContent = {

                    VacancyScreen(
                        {
                            vacancy.value = it
                            navigationState.navigateToDetail(it)
                        },
                        Modifier.padding(padding)
                    )    

            },
            vacancyDetailScreenContent = {
                VacancyDetailScreen(
                    onBackPress = {
                    navigationState.navHostController.popBackStack() },
                    Modifier.padding(padding),
                    vacancy= vacancy.value ?: throw RuntimeException(" Vacancy is null")
                )
            },
            favouriteScreenContent = { FavoriteScreen(
                { //TODO реализовать навигацию на экран деталировки
                    // реализовать правильную навигацию для корректного отображения
                     },
                Modifier.padding(padding)) },
            responseScreenContent = { ResponseScreen() },
            messageScreenContent = { MessageScreen(Modifier.padding(padding)) },
            profileScreenContent = { ProfileScreen() })


    }

}






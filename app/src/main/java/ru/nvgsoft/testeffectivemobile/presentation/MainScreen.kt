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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.nvgsoft.testeffectivemobile.navigation.AppNavGraph
import ru.nvgsoft.testeffectivemobile.navigation.Screen
import ru.nvgsoft.testeffectivemobile.navigation.rememberNavigationState
import ru.nvgsoft.testeffectivemobile.presentation.favourite.FavoriteScreen
import ru.nvgsoft.testeffectivemobile.presentation.message.MessageScreen
import ru.nvgsoft.testeffectivemobile.presentation.profile.ProfileScreen
import ru.nvgsoft.testeffectivemobile.presentation.response.ResponseScreen
import ru.nvgsoft.testeffectivemobile.presentation.vacancy.VacancyScreen


@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val navigationState = rememberNavigationState()


    Scaffold(bottomBar =
    {
        NavigationBar(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .padding(top = 1.dp),
            containerColor = MaterialTheme.colorScheme.background
        ) {

            
            val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
            val currentRout = navBackStackEntry?.destination?.route
            val items = listOf(
                NavigationItem.Find,
                NavigationItem.Favorites,
                NavigationItem.Responses,
                NavigationItem.Message,
                NavigationItem.Profile
            )
            items.forEach { item ->
                NavigationBarItem(

                    selected = currentRout == item.screen.route,
                    onClick = {
                        navigationState.navigateTo(item.screen.route)
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
                    viewModel = viewModel,
                    Modifier.padding(padding)
                )
            },
            favouriteScreenContent = { FavoriteScreen(viewModel, Modifier.padding(padding)) },
            responseScreenContent = { ResponseScreen() },
            messageScreenContent = { MessageScreen(Modifier.padding(padding)) },
            profileScreenContent = { ProfileScreen() })


    }

}






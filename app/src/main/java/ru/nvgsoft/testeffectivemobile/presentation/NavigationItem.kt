package ru.nvgsoft.testeffectivemobile.presentation

import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: Int,

) {
    object Find : NavigationItem(
        screen = Screen.Home,
        titleResId = R.string.navigation_item_search,
        icon = R.drawable.ic_search,
    )

    object Favorites : NavigationItem(
        screen = Screen.Favorite,
        titleResId = R.string.navigation_item_favorites,
        icon = R.drawable.ic_heart,
    )

    object Responses : NavigationItem(
        screen = Screen.Response,
        titleResId = R.string.navigation_item_responses,
        icon = R.drawable.ic_envelope,
    )
    object Message : NavigationItem(
        screen = Screen.Message,
        titleResId = R.string.navigation_item_message,
        icon = R.drawable.ic_message
    )

    object Profile : NavigationItem(
        screen = Screen.Profile,
        titleResId = R.string.navigation_item_profile,
        icon = R.drawable.ic_profile
    )

}
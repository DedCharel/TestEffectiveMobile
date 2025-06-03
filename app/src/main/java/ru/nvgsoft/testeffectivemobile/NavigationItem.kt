package ru.nvgsoft.testeffectivemobile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {
    object Find : NavigationItem(
        titleResId = R.string.navigation_item_search,
        icon = Icons.Outlined.Search
    )

    object Favorites : NavigationItem(
        titleResId = R.string.navigation_item_favorites,
        icon = Icons.Outlined.Favorite
    )

    object Responses : NavigationItem(
        titleResId = R.string.navigation_item_responses,
        icon = Icons.Outlined.MailOutline
    )
    object Message : NavigationItem(
        titleResId = R.string.navigation_item_message,
        icon = Icons.Default.Notifications
    )

    object Profile : NavigationItem(
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )

}
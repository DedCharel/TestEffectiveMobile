package ru.nvgsoft.testeffectivemobile.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.res.stringResource
import ru.nvgsoft.testeffectivemobile.R

sealed class NavigationItem(
    val titleResId: Int,
    val icon: Int,

) {
    object Find : NavigationItem(
        titleResId = R.string.navigation_item_search,
        icon = R.drawable.ic_search,
    )

    object Favorites : NavigationItem(
        titleResId = R.string.navigation_item_favorites,
        icon = R.drawable.ic_heart,
    )

    object Responses : NavigationItem(
        titleResId = R.string.navigation_item_responses,
        icon = R.drawable.ic_envelope,
    )
    object Message : NavigationItem(
        titleResId = R.string.navigation_item_message,
        icon = R.drawable.ic_message
    )

    object Profile : NavigationItem(
        titleResId = R.string.navigation_item_profile,
        icon = R.drawable.ic_profile
    )

}
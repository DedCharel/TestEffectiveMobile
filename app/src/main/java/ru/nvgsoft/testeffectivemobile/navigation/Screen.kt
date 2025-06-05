package ru.nvgsoft.testeffectivemobile.navigation

sealed class Screen(
    val route: String
) {

    object Vacancy: Screen(ROUTE_VACANCY)
    object Favorite: Screen(ROUTE_FAVORITE)
    object Response: Screen(ROUTE_RESPONSE)
    object Message: Screen(ROUTE_MESSAGE)
    object Profile: Screen(ROUTE_PROFILE)

    companion object{

        const val ROUTE_VACANCY = "vacancy"
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_RESPONSE = "response"
        const val ROUTE_MESSAGE = "message"
        const val ROUTE_PROFILE = "profile"
    }

}
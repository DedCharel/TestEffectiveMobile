package ru.nvgsoft.testeffectivemobile.navigation

sealed class Screen(
    val route: String
) {

    object Home: Screen(ROUTE_HOME)
    object VacancyDetail: Screen(ROUTE_VACANCY_DETAIL){
//        private const val ROUTE_FOR_ARGS = "vacancy_detail"
//        fun getRouteWithArgs(vacancy: VacancyModel): String{
//            val vacancyGson = Gson().toJson(vacancy)
//            return "$ROUTE_FOR_ARGS/${vacancyGson.encode()}"
//
//        }
    }
    object Vacancy: Screen(ROUTE_VACANCY)
    object Favorite: Screen(ROUTE_FAVORITE)
    object Response: Screen(ROUTE_RESPONSE)
    object Message: Screen(ROUTE_MESSAGE)
    object Profile: Screen(ROUTE_PROFILE)

    companion object{


        const val KEY_VACANCY_DETAIL = "vacancy_key"

        const val ROUTE_HOME = "home"
        const val ROUTE_VACANCY_DETAIL = "vacancy_detail"
        const val ROUTE_VACANCY = "vacancy"
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_RESPONSE = "response"
        const val ROUTE_MESSAGE = "message"
        const val ROUTE_PROFILE = "profile"
    }

}
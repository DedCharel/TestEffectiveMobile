package ru.nvgsoft.testeffectivemobile.domain.entity


data class VacancyEntity(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val addressTown: String,
    val addressStreet: String,
    val addressHouse: String,
    val company: String,
    val experiencePreviewText: String,
    val experienceText: String,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salaryFull: String,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
) {
//    companion object{
//        val NavigationType: NavType<VacancyModel> = object : NavType<VacancyModel>(false) {
//            override fun get(bundle: Bundle, key: String): VacancyModel? {
//                return bundle.getParcelable(key)
//            }
//
//            override fun parseValue(value: String): VacancyModel {
//                return Gson().fromJson(value, VacancyModel::class.java)
//            }
//
//            override fun put(bundle: Bundle, key: String, value: VacancyModel) {
//                bundle.putParcelable(key, value)
//            }
//
//        }
//    }
}




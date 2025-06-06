package ru.nvgsoft.testeffectivemobile.domain.entity


data class VacancyModel(
    val id: String = "cbf0c984-7c6c-4ada-82da-e29dc698bb50",
    val lookingNumber: Int = 2,
    val title: String = "UI/UX дизайнер",
    val addressTown: String =  "Минск",
    val addressStreet: String = "улица Бирюзова",
    val addressHouse: String = "4",
    val company: String = "Мобирикс",
    val experiencePreviewText: String = "Опыт от 1 до 3 лет",
    val experienceText: String =  "1–3 года",
    val publishedDate: String = "2024-02-20",
    val isFavorite: Boolean = false,
    val salaryFull: String = "Уровень дохода не указан",
    val schedules: List<String> = listOf("полная занятость", "полный день"), //enum
    val appliedNumber: Int = 147,
    val description: String? = "Мы ищем специалиста на позицию UX/UI Designer, который вместе с коллегами будет заниматься проектированием пользовательских интерфейсов внутренних и внешних продуктов компании.",
    val responsibilities: String = "- проектирование пользовательских сценариев и создание прототипов;\n" +
            "- разработка интерфейсов для продуктов компании (Web+App);\n" +
            "- работа над созданием и улучшением Дизайн-системы;\n" +
            "- взаимодействие с командами frontend-разработки;\n" +
            "- контроль качества внедрения дизайна;\n" +
            "- ситуативно: создание презентаций и других материалов на основе фирменного стиля компании",
    val questions: List<String> = listOf("Где располагается место работы?",
        "Какой график работы?",
        "Вакансия открыта?",
        "Какая оплата труда?")
) {
    companion object{
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
    }
}




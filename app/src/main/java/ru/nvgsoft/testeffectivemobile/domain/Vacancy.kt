package ru.nvgsoft.testeffectivemobile.domain

data class Vacancy(
    val id: String = "cbf0c984-7c6c-4ada-82da-e29dc698bb50",
    val lookingNumber: Int = 2,
    val title: String = "UI/UX дизайнер",
    val address: Address = Address(town = "Минск", street = "улица Бирюзова", house = "4"),
    val company: String = "Мобирикс",
    val experience: Experience = Experience("Опыт от 1 до 3 лет", "1–3 года"),
    val publishedDate: String = "2024-02-20",
    val isFavorite: Boolean = false,
    val salary: Salary = Salary(full = "Уровень дохода не указан"),
    val schedules: List<String> = listOf("полная занятость", "полный день"), //enum
    val appliedNumber: Int = 147,
    val description: String = "Мы ищем специалиста на позицию UX/UI Designer, который вместе с коллегами будет заниматься проектированием пользовательских интерфейсов внутренних и внешних продуктов компании.",
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
)
data class Salary(
    val full: String = "",
    val short:String = ""
)

data class Experience(
    val previewText: String,
    val text: String
)
data class Address(
    val town:String,
    val street: String,
    val house: String
)

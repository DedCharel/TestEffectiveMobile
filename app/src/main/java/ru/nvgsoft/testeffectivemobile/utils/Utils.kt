package ru.nvgsoft.testeffectivemobile.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toFormattedDate(): String {
    return try {
        val formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(this, formatterInput)

        val formatterOutput = DateTimeFormatter.ofPattern(
            "d MMMM yyyy",
            java.util.Locale("ru", "RU")
        )
        date.format(formatterOutput)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    } catch (e: Exception) {
        this
    }
}

fun <T> Flow<T>.mergeWith(another: Flow<T>): Flow<T> {
    return merge(this, another)
}
fun declension( number: Int, one: String, two:String, five: String): String{
    var n = Math.abs(number)
    n %= 100
    if (n in 5..20) {
        return five
    }
    n %= 10
    if (n === 1) {
        return one
    }
    if (n in 2..4) {
        return two
    }
    return five

}

fun declensionVacancy(number: Int): String{
    return declension(number, "вакансия", "вакансии", "вакансий")
}
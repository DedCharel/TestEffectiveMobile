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
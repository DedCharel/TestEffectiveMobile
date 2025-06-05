package ru.nvgsoft.testeffectivemobile.utils

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
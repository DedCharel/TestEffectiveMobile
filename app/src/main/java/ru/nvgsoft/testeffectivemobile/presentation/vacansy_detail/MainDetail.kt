package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

@Composable
fun MainInfoDetail(
    vacancy: VacancyModel,
    modifier: Modifier = Modifier
){
    Text(
        modifier = modifier,
        text = vacancy.title,
        color = Color.White,
        fontSize = 22.sp
    )
    Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = modifier,
            text = vacancy.salaryFull,
            color = Color.White,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

    Text(
        modifier = modifier,
        text = "Требуемый опыт: ${vacancy.experiencePreviewText}",
        color = Color.White,
        fontSize = 14.sp
    )
    Spacer(modifier = Modifier.height(8.dp))


    Text(
        modifier = modifier,
        text = vacancy.schedules.joinToString(),
        color = Color.White,
        fontSize = 14.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
}
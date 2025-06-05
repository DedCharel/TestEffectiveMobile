package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

@Composable
fun TasksDetail(
    vacancy: VacancyModel,
    modifier: Modifier = Modifier
){
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = vacancy.description,
        color = Color.White)
    Spacer(modifier = Modifier.height(16.dp))
    Text(

        text = stringResource(R.string.your_tasks),
        color = Color.White,
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = vacancy.responsibilities,
        color = Color.White,
        fontSize = 14.sp
    )
    Spacer(modifier = Modifier.height(20.dp))
}
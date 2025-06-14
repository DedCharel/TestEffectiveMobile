package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity

@Composable
fun QuestionDetail(vacancy: VacancyEntity) {
    Text(
        text = stringResource(R.string.ask_question),
        color = Color.White,
        style = MaterialTheme.typography.titleSmall
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = stringResource(R.string.question_with_response),
        color = Color.Gray,
        style = MaterialTheme.typography.titleSmall
    )
    Spacer(modifier = Modifier.height(12.dp))
    Column {
        vacancy.questions.forEach {
            Box(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.surface,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(12.dp)
            ) {
                Text(
                    text = it,
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
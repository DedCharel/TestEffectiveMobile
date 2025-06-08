package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.presentation.getApplicationComponent


@Composable
fun VacancyDetailScreen(

    onBackPress: () -> Unit,
    modifier: Modifier = Modifier,
    vacancy: VacancyEntity

    ) {

    val component = getApplicationComponent()
    val viewModel: VacancyDetailViewModel = viewModel(factory = component.getViewModelFactory())

    LazyColumn(modifier.padding(start = 16.dp, end = 16.dp)) {
        item {
            TopBarDetail(
                vacancy = vacancy,
                onFavoriteClick = {
                    viewModel.changeFavouriteStatus(it)
                },
                onBackPress = onBackPress
            )
            MainInfoDetail(vacancy)
            ApplyDetails(vacancy)
            CompanyDetail(vacancy)
            TasksDetail(vacancy)
            QuestionDetail(vacancy)

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.onSurface
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier

                    .fillMaxWidth(),
                onClick = { },
            ) {

                Text(
                    text = stringResource(R.string.response),
                    style = MaterialTheme.typography.labelLarge
                )
            }

        }

    }
}







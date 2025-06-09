package ru.nvgsoft.testeffectivemobile.presentation.favourite

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.presentation.ViewModelFactory
import ru.nvgsoft.testeffectivemobile.presentation.getApplicationComponent
import ru.nvgsoft.testeffectivemobile.presentation.vacancy.VacancyPreviewCard
import ru.nvgsoft.testeffectivemobile.utils.declensionVacancy

@Composable
fun FavoriteScreen(
    onVacancyCLick: (VacancyEntity) -> Unit,
    modifier: Modifier = Modifier
){
    val component = getApplicationComponent()
    val viewModel: FavouriteViewModel = viewModel(factory = component.getViewModelFactory())
    val vacancies = viewModel.vacancy.collectAsState(listOf()).value
    val size = vacancies?.size
    LazyColumn (modifier. padding(start = 16.dp, top = 16.dp, end = 16.dp)) {

        item {
            Text(text = "Избранное", color = Color.White, fontSize = 20.sp)
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Text(text = "$size ${declensionVacancy(size ?:0)}", color = Color.Gray, fontSize = 14.sp)
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(vacancies, key = {it.id}){
            VacancyPreviewCard(
                it,
                onFavouriteClick = { vacancy ->
                    viewModel.changeFavouriteStatus(vacancy)} ,
                onVacancyCLick = {onVacancyCLick(it)},
                Modifier.padding(bottom = 8.dp)

            )
        }


    }
}
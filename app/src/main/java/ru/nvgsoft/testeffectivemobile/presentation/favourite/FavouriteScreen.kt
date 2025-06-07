package ru.nvgsoft.testeffectivemobile.presentation.favourite

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.nvgsoft.testeffectivemobile.presentation.vacancy.VacancyPreviewCard

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier
){
    val viewModel: FavouriteViewModel = viewModel()
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
            Text(text = "$size вакансий", color = Color.Gray, fontSize = 14.sp)
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(vacancies, key = {it.id}){
            VacancyPreviewCard(
                it,
                onFavouriteClick = { vacancy ->
                    viewModel.changeFavouriteStatus(vacancy)} ,
                onVacancyCLick = {},
                Modifier.padding(bottom = 8.dp)

            )
        }


    }
}
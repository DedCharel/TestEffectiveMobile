package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

@Composable
fun VacancyScreen(
    onVacancyClick: (VacancyModel) -> Unit,
    modifier: Modifier = Modifier
){

    val viewModel: VacancyViewModel = viewModel()
    val screenState = viewModel.screenState.observeAsState(VacancyScreenState.Initial)



    when (val currentState  = screenState.value){
        is VacancyScreenState.VacancyList ->{
            VacancyListScreen(
                viewModel = viewModel,
                vacancies = currentState.vacancyList,
                offers =currentState.offersList,
                onVacancyClick = onVacancyClick,
                modifier)

        }

        VacancyScreenState.Initial -> {}
    }



}

@Composable
fun VacancyListScreen(
    viewModel: VacancyViewModel,
    vacancies: List<VacancyModel>,
    offers: List<OfferModel>,
    onVacancyClick: (VacancyModel) -> Unit,
    modifier: Modifier = Modifier
){
    val isShowAllVacancy = rememberSaveable() {
        mutableStateOf(false)
    }

    Box(modifier = modifier){

        LazyColumn() {
            item  {
                SearchBox()
            }

            if  (!isShowAllVacancy.value){
                item {
                    LazyRow (Modifier.padding(top = 16.dp, start = 16.dp)) {

                        items(offers, key = { it.id } ){
                            OfferPreviewCard(it)
                        }
                    }
                }
            }

            if (isShowAllVacancy.value){
                item {
                    VacancyByRequirements(vacancies.size, Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp))
                }
            }

            item {
                Text(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                    text = stringResource(R.string.vacancy_for_you),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

            items(vacancies, key = { it.id}){
                VacancyPreviewCard(
                    it,
                    onFavouriteClick = {vacancy ->
                        viewModel.changeFavourite(vacancy)} ,
                    onVacancyCLick = {vacancy ->
                        onVacancyClick(vacancy)
                        },
                    Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp))
            }

            item {
                if (!isShowAllVacancy.value){
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 8.dp
                            )
                            .fillMaxWidth(),
                        onClick = { isShowAllVacancy.value = !isShowAllVacancy.value },
                    ) {
                        val size =vacancies.size
                        Text(text = "Еще ${size - 3} вакансии")
                    }
                }

            }

        }
    }
}

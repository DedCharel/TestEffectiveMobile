package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferEntity
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.presentation.ViewModelFactory
import ru.nvgsoft.testeffectivemobile.presentation.getApplicationComponent
import ru.nvgsoft.testeffectivemobile.utils.declensionVacancy

@Composable
fun VacancyScreen(
    onVacancyClick: (VacancyEntity) -> Unit,
    modifier: Modifier = Modifier
) {

    val component = getApplicationComponent()
    val viewModel: VacancyViewModel = viewModel(factory = component.getViewModelFactory())
    val vacancyScreenState = viewModel.vacancyScreenState.collectAsState(VacancyScreenState.Initial)
    val offerScreenState = viewModel.offerScreenState.collectAsState(OfferScreenState.Initial)
    val currentVacancyState: VacancyScreenState = vacancyScreenState.value
    val currentOfferState: OfferScreenState = offerScreenState.value


    if (currentVacancyState is VacancyScreenState.VacancyList && currentOfferState is OfferScreenState.OfferList) {
        VacancyListScreen(
            viewModel = viewModel,
            vacancies = currentVacancyState.vacancyList,
            offers = currentOfferState.offers,
            onVacancyClick = onVacancyClick,
            modifier
        )
    }else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.White)
        }
    }
}


@Composable
fun VacancyListScreen(
    viewModel: VacancyViewModel,
    vacancies: List<VacancyEntity>,
    offers: List<OfferEntity>,
    onVacancyClick: (VacancyEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    val isShowAllVacancy = rememberSaveable() {
        mutableStateOf(false)
    }
    val currentVacancies =
        if (vacancies.size > 2 && !isShowAllVacancy.value) vacancies.take(3) else vacancies
    //TODO Реализовать через подгрузку данных
    Box(modifier = modifier) {

        LazyColumn() {
            item {
                SearchBox()
            }

            if (!isShowAllVacancy.value) {
                item {
                    LazyRow(Modifier.padding(top = 16.dp, start = 16.dp)) {

                        items(offers, key = { it.id }) {
                            OfferPreviewCard(it)
                        }
                    }
                }
            }

            if (isShowAllVacancy.value) {
                item {
                    VacancyByRequirements(
                        vacancies.size,
                        Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    )
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

            items(currentVacancies, key = { it.id }) {
                VacancyPreviewCard(
                    it,
                    onFavouriteClick = { vacancy ->
                        viewModel.changeFavouriteStatus(vacancy)
                    },
                    onVacancyCLick = { vacancy ->
                        onVacancyClick(vacancy)
                    },
                    Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
            }

            item {

                if (!isShowAllVacancy.value && vacancies.size > 3 ) {
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

                        val size = vacancies.size -3
                        Text(text = "Еще ${size} ${declensionVacancy(size)}")
                    }
                }

            }

        }
    }
}

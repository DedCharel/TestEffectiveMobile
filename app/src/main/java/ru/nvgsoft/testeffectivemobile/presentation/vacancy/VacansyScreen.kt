package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel
import ru.nvgsoft.testeffectivemobile.presentation.MainViewModel

@Composable
fun VacancyScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
){
    val vacancy = viewModel.vacancy.observeAsState(listOf( VacancyModel()))
    val offers = viewModel.offers.observeAsState(listOf())
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

                        items(offers.value, key = { it.id } ){
                            OfferPreviewCard(it)
                        }
                    }
                }
            }

            if (isShowAllVacancy.value){
                item {
                    VacancyByRequirements(vacancy.value.size, Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp))
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

            items(vacancy.value, key = { it.id}){
                VacancyPreviewCard(
                    it,
                    onFavouriteClick = { viewModel.changeFavourite(it)} ,
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
                        val size =vacancy.value.size
                        Text(text = "Еще ${size - 3} вакансии")
                    }
                }

            }

        }
    }
}

@Composable
fun SearchBox(){
    Row (
        Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()


    ){
        Row(
            modifier = Modifier
                .height(40.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface)

                .weight(1f)
                .align(Alignment.CenterVertically)
        ){

            Image(painter = painterResource(id = R.drawable.ic_find), contentDescription = null,
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp))

            BasicTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
            )

        }


        Image(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(40.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.filter),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )

    }
}
@Composable
fun VacancyByRequirements(
    size: Int,
    modifier: Modifier = Modifier){
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "$size вакансий", color = Color.White, fontSize = 14.sp)
        Row(){
            Text(text = "По соотвествию", color = Color.Blue,  fontSize = 14.sp)
            Spacer(modifier = Modifier.size(8.dp))
            Icon( painter = painterResource(id = R.drawable.ic_sort),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.CenterVertically),
                tint = Color.Blue)
        }


    }
}
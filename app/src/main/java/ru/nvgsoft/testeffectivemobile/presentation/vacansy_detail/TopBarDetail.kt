package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity

@Composable
fun TopBarDetail(
   vacancy: VacancyEntity,
    onBackPress: () -> Unit,
    onFavoriteClick: (VacancyEntity) ->Unit,
    modifier: Modifier = Modifier
) {

    //временное решение нужно обновлять вакансию через flow
    val isFavourite: MutableState<Boolean> = remember {
        mutableStateOf(vacancy.isFavorite)
    }

    Row(
        modifier = modifier
            .padding(top = 16.dp , bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable {
                onBackPress()
            }
        )
        Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxWidth()) {
            Row(horizontalArrangement = Arrangement.End) {
                Icon(
                    painter = painterResource(R.drawable.ic_eyes),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(12.dp))


                var iconFavorite = painterResource(R.drawable.ic_heart)
                var tintColor = Color.White
                if (isFavourite.value) {
                    tintColor = MaterialTheme.colorScheme.onPrimary
                    iconFavorite = painterResource(R.drawable.ic_heart2)
                }
                Icon(
                    modifier = Modifier.clickable {
                        isFavourite.value = !isFavourite.value
                        onFavoriteClick(vacancy)
                    },
                    painter = iconFavorite,
                    contentDescription = null,
                    tint = tintColor
                )
            }
        }
    }
}
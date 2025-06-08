package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.utils.toFormattedDate

@Composable
fun VacancyPreviewCard(
    vacancy: VacancyEntity,
    onFavouriteClick: (VacancyEntity)-> Unit,
    onVacancyCLick: (VacancyEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onVacancyCLick(vacancy)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            var iconFavorite = painterResource(R.drawable.ic_heart)
            var tintColor = Color.Gray
            if (vacancy.isFavorite) {
                tintColor = MaterialTheme.colorScheme.onPrimary
               iconFavorite = painterResource(R.drawable.ic_heart2)
            }
            Icon(
                iconFavorite ,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 16.dp)
                    .size(24.dp)
                    .clickable { onFavouriteClick(vacancy) },
                tint = tintColor,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 10.dp)
                    .fillMaxWidth(0.8f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (vacancy.lookingNumber > 0){
                    Text(
                        text = "Сейчас просматривает ${vacancy.lookingNumber} человек",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Text(
                    text = vacancy.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
                Column {
                    Text(
                        text = vacancy.addressTown,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White)
                    Row {
                        Text(
                            text = vacancy.company,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White)
                        Image(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .align(Alignment.CenterVertically),
                            painter = painterResource(id = R.drawable.check),
                            contentDescription = null,
                            )
                    }

                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.experience),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = vacancy.experiencePreviewText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }

                Text(
                    text = "Опубликованно ${vacancy.publishedDate.toFormattedDate()}",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = MaterialTheme.colorScheme.onSurface
            )
        )
        {
            Text(text = stringResource(R.string.response), style = MaterialTheme.typography.labelMedium,)
        }


    }
}



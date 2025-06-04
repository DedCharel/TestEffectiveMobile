package ru.nvgsoft.testeffectivemobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VacancyPreviewCard() {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Icon(
                Icons.Outlined.Favorite,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 16.dp), contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 10.dp)
                    .fillMaxWidth(0.8f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Сейчас просматривает 1 человек",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 14.sp
                )
                Text(
                    text = "Наименование вакансии очень длинный текст для проверки",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Column {
                    Text(text = "Город", fontSize = 14.sp, color = Color.White)
                    Row {
                        Text(text = "Организация", fontSize = 14.sp, color = Color.White)
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
                        text = "Опыт от 1 до 3 лет",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

                Text(text = "Опубликованно 20 января")
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
            Text(text = "Откликнутся")
        }


    }
}

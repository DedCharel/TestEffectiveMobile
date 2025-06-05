package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

@Composable
fun CompanyDetail(
    vacancy: VacancyModel,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.secondary,
                RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
    ) {
        Column(modifier.padding(8.dp)) {
            Row {
                Text(
                    text = vacancy.company,
                    color = Color.White,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_done),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = null,
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${vacancy.address.town}, ${vacancy.address.street}, ${vacancy.address.house}",
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
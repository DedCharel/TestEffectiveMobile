package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

@Composable
fun ApplyDetails(
    vacancy: VacancyModel,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier.wrapContentHeight(),
        horizontalArrangement = Arrangement.Center) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onTertiary, RoundedCornerShape(10.dp))

                .weight(0.5f)
                .padding(8.dp)
        ) {
            Text(
                text = "${vacancy.appliedNumber} человек уже откликнулось",
                color = Color.White,
                fontSize = 14.sp
            )
            Icon(
                painterResource(id = R.drawable.ic_profile),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSurface),
                tint = Color.White,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onTertiary, RoundedCornerShape(10.dp))

                .weight(0.5f)
                .padding(8.dp)
        ) {
            Text(
                text = "${vacancy.lookingNumber} человека сейчас смотрят",
                color = Color.White,
                fontSize = 14.sp
            )
            Icon(
                painterResource(id = R.drawable.ic_eyes),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSurface),
                tint = Color.White,
                contentDescription = null
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
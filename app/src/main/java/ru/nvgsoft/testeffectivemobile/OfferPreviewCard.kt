package ru.nvgsoft.testeffectivemobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OfferPreviewCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(end = 16.dp, bottom = 8.dp)
            .width(132.dp)
            .height(120.dp),
        shape = RoundedCornerShape(percent = 8),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        onClick = { /*TODO*/ }) {
        Image(
            painter = painterResource(id = R.drawable.vacancy2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 8.dp, top = 10.dp, bottom = 8.dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onPrimary),

            )


        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(text = "Вакансии рядом с вами", fontSize = 14.sp, color = Color.White)
            Text(text = "Поднять", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
        }

    }
}


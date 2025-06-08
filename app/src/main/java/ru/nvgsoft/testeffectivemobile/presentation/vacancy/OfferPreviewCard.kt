package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import android.content.Intent
import android.net.Uri
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferEntity


@Composable
fun OfferPreviewCard(
    offer: OfferEntity,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
  Card(
        modifier = modifier
            .padding(end = 16.dp, bottom = 8.dp)
            .width(132.dp)
            .height(120.dp),
        shape = RoundedCornerShape(percent = 8),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(offer.link))
            context.startActivity(intent)
         }) {
        

        Icon(

            modifier = Modifier
                .padding(start = 8.dp, top = 10.dp, bottom = 8.dp)
                .clip(CircleShape)
                .background(GetOfferIconBackground(id = offer.id))
                .size(32.dp),
            contentDescription = null,
            painter = GetOfferIcon(id = offer.id)


            )


        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = offer.title,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White)
            if (offer.buttonText != null){
                Text(
                    text = offer.buttonText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface)
            }

        }

    }
}

@Composable
fun GetOfferIcon(id: String): Painter =
    when (id){
        "level_up_resume" -> painterResource(id = R.drawable.ic_star)
        "temporary_job" -> painterResource(id = R.drawable.ic_doc)
        else -> painterResource(id = R.drawable.ic_empty)
    }


@Composable
fun GetOfferIconBackground(id: String): Color =
    when (id) {
        "near_vacancies" -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.onTertiary
    }

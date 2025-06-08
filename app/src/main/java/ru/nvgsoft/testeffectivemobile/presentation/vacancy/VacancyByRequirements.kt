package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nvgsoft.testeffectivemobile.R
import ru.nvgsoft.testeffectivemobile.utils.declensionVacancy


@Composable
fun VacancyByRequirements(
    size: Int,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween){
        val vac = declensionVacancy(size)
        Text(text = "$size $vac",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
        Row(){
            Text(
                text = "По соотвествию",
                color = Color.Blue,
                style = MaterialTheme.typography.bodyMedium
                )
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
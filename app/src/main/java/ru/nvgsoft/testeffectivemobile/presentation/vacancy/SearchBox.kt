package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.nvgsoft.testeffectivemobile.R

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
package ru.nvgsoft.testeffectivemobile.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.nvgsoft.testeffectivemobile.R

@Preview
@Composable
fun Test(){
    Icon(


        tint = Color.Green,
        painter = painterResource(id = R.drawable.ic_star),
        contentDescription = null,



        )
}
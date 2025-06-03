package ru.nvgsoft.testeffectivemobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(){
    Scaffold(bottomBar =
    {
        NavigationBar (
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .padding(top = 1.dp),
            containerColor = MaterialTheme.colorScheme.background
        ){

            val selectedPosition = rememberSaveable {
                mutableStateOf(0)
            }
            val items = listOf(
                NavigationItem.Find,
                NavigationItem.Favorites,
                NavigationItem.Responses,
                NavigationItem.Message,
                NavigationItem.Profile
            )
            items.forEachIndexed { index,  item ->
                NavigationBarItem(

                    selected = selectedPosition.value == index,
                    onClick = {
                        selectedPosition.value = index
                    },
                    icon = {
                        Icon(item.icon, contentDescription = null)
                    },
                    label =  {
                        Text(text = stringResource(id = item.titleResId), fontSize = 11.sp)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        indicatorColor = MaterialTheme.colorScheme.background
                    )

                )
            }
        }
    }) {padding ->
        LazyColumn (modifier = Modifier.padding(padding) ) {
            repeat(10){
                item(){
                    VacancyPreviewCard( )
                }
            }

        }


    }
}
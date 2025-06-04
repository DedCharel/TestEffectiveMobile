package ru.nvgsoft.testeffectivemobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
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


            Box(modifier = Modifier.padding(padding)){

                LazyColumn() {
                    item  {
                        SearchBox()
                    }

                    item {
                        LazyRow (Modifier.padding(top = 16.dp, start = 16.dp, bottom = 8.dp)) {
                            repeat(4){
                                item {
                                    OfferPreviewCard()
                                }
                            }
                        }
                    }

                    item {
                        Text(
                            modifier = Modifier.padding(
                                start = 16.dp,
                                top = 16.dp,
                                bottom = 8.dp
                            ),
                            text = "Вакансии для вас",
                            fontSize = 22.sp,
                            color = Color.White
                        )
                    }
                    repeat(3) {
                        item() {
                            VacancyPreviewCard()
                        }
                    }
                    item {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                containerColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .padding(
                                    start = 15.dp,
                                    end = 15.dp,
                                    top = 8.dp
                                )
                                .fillMaxWidth(),
                            onClick = {  },
                           ) {
                                Text(text = "Еще 143 вакансии")
                        }
                    }

                }

            }

        }

}


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

                .weight(1f).align(Alignment.CenterVertically)
        ){

            Image(painter = painterResource(id = R.drawable.ic_find), contentDescription = null, Modifier.align(Alignment.CenterVertically).padding(start = 8.dp))
//            OutlinedTextField(
//                modifier = Modifier
//                    .fillMaxSize(),
//                leadingIcon = {
//                    Icon(painter = painterResource(id = R.drawable.ic_find), contentDescription = null)
//                },
//                value = "",
//                onValueChange = {},
//                placeholder = {
//                    Text(text = "Должность, ключевые слова")},
//
//            )
            BasicTextField(value = "", onValueChange = {}, modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp))
            
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

//        SearchBar(query = "", onQueryChange = {}, onSearch = {} , active = true, onActiveChange ={},
//            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_find), contentDescription = "")} ) {
//
//        }


    }
}



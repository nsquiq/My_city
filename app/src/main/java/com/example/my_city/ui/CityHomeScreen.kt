package com.example.my_city.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.my_city.R
import com.example.my_city.model.ToDo

@Composable
fun CityApp(){

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(){
        TopAppBar(
            title ={
                Text("Vremenno")
            }


        )
}

@Composable
private fun ToDoListItem(
    toDo: ToDo,
    modifier: Modifier = Modifier
){
    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ToDoListImageItem(
                toDo = toDo,
                modifier = Modifier

            )


        }
    }
}

@Composable
private fun ToDoListImageItem(toDo: ToDo,modifier:Modifier = Modifier){
            Box (
                modifier = modifier
            ){
               Image(
                    painter = painterResource(toDo.imageResourceId),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth
                )
                
            }
}

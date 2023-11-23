package com.example.my_city.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.my_city.R

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
private fun ToDoListItem(){
    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {


        }
    }
}
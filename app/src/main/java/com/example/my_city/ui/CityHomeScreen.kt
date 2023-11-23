package com.example.my_city.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.my_city.R
import com.example.my_city.data.CityData
import com.example.my_city.model.ToDo
import com.example.my_city.ui.theme.My_cITYTheme

@Composable
fun CityApp(){
    val viewModel: CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

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
                    .size(84.dp)

            )
            Text(
                text = stringResource(toDo.titleResourceId),

                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(20.dp)


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
@Preview
@Composable
fun ToDoListItemPreview(){
    My_cITYTheme {
        ToDoListItem(toDo = CityData.defaultCity)
    }
    
}

@Composable
private fun ToDoList(
    todos:List<ToDo>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier

){
    LazyColumn(){
        items(todos, key = { toDo ->toDo.id}){toDo ->
            ToDoListItem(toDo = toDo)

        }
    }
}



@Preview
@Composable
fun ToDoListPreview(){
    My_cITYTheme {
        Surface{
            ToDoList(
                todos = CityData.getCityData()
           )
       }
    }
}

@Composable
private fun Recomendations(
    selectedToDo: ToDo,

    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){



    Text(
        text = stringResource(selectedToDo.recomend1))
    Text(
        text = stringResource(selectedToDo.recomend2))
    Text(
        text = stringResource(selectedToDo.recomend3))
    Text(
        text = stringResource(selectedToDo.recomend4))
    Text(
        text = stringResource(selectedToDo.recomend5))


}


@Composable
private fun SportsListAndDetail(
    sports: List<Sport>,
    selectedSport: Sport,
    onClick: (Sport) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    Row(
        modifier = modifier
    ) {
        SportsList(
            sports = sports,
            onClick = onClick,
            contentPadding = contentPadding,
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        SportsDetail(
            selectedSport = selectedSport,
            modifier = Modifier.weight(3f),
            contentPadding = contentPadding,
            onBackPressed = onBackPressed,
        )
    }






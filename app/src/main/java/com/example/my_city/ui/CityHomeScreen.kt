package com.example.my_city.ui

import android.annotation.SuppressLint
import android.graphics.pdf.PdfDocument.Page
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
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
import com.example.my_city.ui.utils.ContentType
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Devices
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityApp(

    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit,

){
    val viewModel: CityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact ,

        WindowWidthSizeClass.Medium -> ContentType.ListOnly
        WindowWidthSizeClass.Expanded -> ContentType.ListAndDetail

        else -> ContentType.ListOnly

    }
    Scaffold(
        topBar = {
            CityAppBar(
                isShowingListPage = uiState.isShowingListPage,
                onBackButtonClick = { viewModel.navigateToListPage()},
                windowSize = windowSize
            )
        }
    ){ innerPadding ->
        if(contentType == ContentType.ListAndDetail){
            RecomendationAndList(
                todos = uiState.toDoList,
                selectedToDo = uiState.currentToDo,

                
                onClick = {
                    viewModel.updateCurrentToDo(it)
                },
                onBackPressed = onBackPressed,
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxWidth()
                    
            )
        }else{


        if(uiState.isShowingListPage){
            ToDoList(todos = uiState.toDoList,
                onClick = {
                    viewModel.updateCurrentToDo(it)
                    viewModel.navigateToDetailPage()
                },
               contentPadding = innerPadding,)

        }
        else if(uiState.isShowingInfPage){
            Informations(
                selectedToDo = uiState.currentToDo,
                onBackPressed = {  viewModel.navigateToListPage()},
                contentPadding = innerPadding )
        }



        else
         {
            Recomendations(
                selectedToDo = uiState.currentToDo,
                contentPadding = innerPadding,
                onBackPressed = {
                    viewModel.navigateToListPage()
                },
                onClick = {
                    viewModel.navigateToInfPage()
                }

            )
        }
    }
}}




@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar(
    onBackButtonClick: () -> Unit,
    isShowingListPage: Boolean,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
){
    val isShowingDetailPage = windowSize != WindowWidthSizeClass.Expanded && !isShowingListPage

        TopAppBar(
            title ={
                Text(
                    text =
                        if(isShowingDetailPage){
                            stringResource(R.string.recomend_label)
                        }else{
                            stringResource(R.string.main_label)
                        }
                )
            },
            navigationIcon = if (isShowingDetailPage){
                {
                    IconButton(onClick = onBackButtonClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.backbutton)

                        )
                    }
                } }
                else{
                    {Box {}}
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = modifier,
                )

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToDoListItem(
    toDo: ToDo,
    onItemClick:(ToDo)->Unit,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(toDo)}
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
        ToDoListItem(toDo = CityData.defaultCity,
            onItemClick = {})
    }
    
}

@Composable
private fun ToDoList(
    todos:List<ToDo>,
    onClick:(ToDo) ->Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier

){
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier,
    ){
        items(todos, key = { toDo ->toDo.id}){toDo ->
            ToDoListItem(
                toDo = toDo,
                onItemClick = onClick)

        }
    }
}



@Preview
@Composable
fun ToDoListPreview(){
    My_cITYTheme {
        Surface{
            ToDoList(
                todos = CityData.getCityData(),
                onClick = {}
           )
       }
    }
}




@Composable
private fun RecomendationAndList(
    todos: List<ToDo>,
    selectedToDo: ToDo,
    onClick: (ToDo) -> Unit,
    onBackPressed: () -> Unit,
    modifier:Modifier = Modifier,

    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    Row(
        modifier = modifier
    ){
        ToDoList(
            todos = todos,
            onClick = onClick,
            contentPadding = contentPadding,
            modifier = Modifier.weight(2f)
               )
        Recomendations(
            selectedToDo = selectedToDo,
            onBackPressed = onBackPressed,
            contentPadding = contentPadding,
            onClick = onClick,
            )


    }
}

@Preview(device = Devices.TABLET)
@Composable
fun RecomendationsAndListPreview(){
    My_cITYTheme {
        Surface{
            RecomendationAndList(
                todos = CityData.getCityData(),
                selectedToDo = CityData.getCityData().getOrElse(0){
                                                                  CityData.defaultCity
                }
                ,
                onClick = {},
                onBackPressed = { },
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Recomendations(
    selectedToDo: ToDo,
    onBackPressed: () -> Unit,
    onClick:(ToDo)->Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current


    Column(
        modifier = modifier
           .verticalScroll(state = scrollState)
            .padding(16.dp)
    ) {
        Card(
            elevation = CardDefaults.cardElevation(),
            modifier = modifier,
            shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
            onClick = { onClick(selectedToDo)},
        ){
        Text(
            text = stringResource(selectedToDo.subtitleResourceId),
            color = MaterialTheme.colorScheme.primary,

            modifier = Modifier

                .padding(8.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                .width(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp)


        )}
        Text(
            text = stringResource(selectedToDo.subtitleResourceId2),

            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                .width(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
        Text(
            text = stringResource(selectedToDo.subtitleResourceId3),

            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                .width(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
        Text(
            text = stringResource(selectedToDo.subtitleResourceId4),

            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                .width(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
        Text(
            text = stringResource(selectedToDo.subtitleResourceId5),

            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                .width(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
    }
}
@Composable
private fun Informations(
    selectedToDo: ToDo,
    onBackPressed: () -> Unit,

    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current


    Column(
        modifier = modifier
            .verticalScroll(state = scrollState)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(selectedToDo.titleResourceId),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                .width(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp)
        )

    }
}



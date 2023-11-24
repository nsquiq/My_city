package com.example.my_city.ui

import android.annotation.SuppressLint
import android.graphics.pdf.PdfDocument.Page
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit
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


        if(uiState.isShowingListPage){
            ToDoList(todos = uiState.toDoList,
                onClick = {
                    viewModel.updateCurrentToDo(it)
                    viewModel.navigateToDetailPage()
                })

        }else {
            Recomendations(
                selectedToDo = uiState.currentToDo,
                contentPadding = innerPadding,
                onBackPressed = {
                    viewModel.navigateToListPage()
                }
            )
        }
    }
}




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
                            stringResource(R.string.busTour2)
                        }else{
                            stringResource(R.string.busTour)
                        }
                )
            }



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
    LazyColumn(){
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
private fun Recomendations(
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



    Text(
        text = stringResource(selectedToDo.titleResourceId),
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.onSurface, // You can adjust the color based on your theme
        modifier = Modifier
    )
    Text(
        text = stringResource(selectedToDo.recomend2),
        color = MaterialTheme.colorScheme.onSurface
    )
    Text(
        text = stringResource(selectedToDo.recomend3),
        color = MaterialTheme.colorScheme.onSurface
    )
    Text(
        text = stringResource(selectedToDo.recomend4),
        color = MaterialTheme.colorScheme.onSurface
    )
    Text(
        text = stringResource(selectedToDo.recomend5),
        color = MaterialTheme.colorScheme.onSurface
    )


}



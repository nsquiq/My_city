package com.example.my_city.ui


import androidx.lifecycle.ViewModel
import com.example.my_city.data.CityData
import com.example.my_city.model.ToDo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * View Model for Sports app
 */
class CityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        CityUiState(
            toDoList = CityData.getCityData(),
            currentToDo = CityData.getCityData().getOrElse(0) {
                CityData.defaultCity
            }
        )
    )
    val uiState: StateFlow<CityUiState> = _uiState

    fun updateCurrentToDo(selectedToDo: ToDo) {
        _uiState.update {
            it.copy(currentToDo = selectedToDo)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }


    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false ,isShowingInfPage = false)

    }
}
    fun navigateToInfPage(){
        _uiState.update{
            it.copy(isShowingInfPage = true)
        }

    }    }

data class CityUiState(
    val toDoList: List<ToDo> = emptyList(),
    val currentToDo: ToDo = CityData.defaultCity,
    val isShowingListPage: Boolean = true,
    val isShowingInfPage: Boolean = true
)
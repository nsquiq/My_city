package com.example.my_city.data

import com.example.my_city.model.ToDo
import com.example.my_city.R

object CityData {
    val defaultCity = getCityData()[0]

    fun getCityData(): List<ToDo> {
        return listOf(
            ToDo(
                id = 1,
                titleResourceId =R.string.busTour ,
                imageResourceId = R.drawable.todo1
            )
        )
    }
}
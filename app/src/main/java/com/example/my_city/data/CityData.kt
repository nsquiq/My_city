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
                imageResourceId = R.drawable.todo1,
                subtitleResourceId = R.string.busTour1,


           ),

            ToDo(
                id = 2,
                titleResourceId =R.string.dayTrips ,
                imageResourceId = R.drawable.todo2,
                        subtitleResourceId = R.string.dayTrips1,

        ),
            ToDo(
                id = 3,
                titleResourceId =R.string.cityTour ,
                imageResourceId = R.drawable.todo3,

                subtitleResourceId = R.string.cityTour1,

            ),

            ToDo(
                id = 4,
                titleResourceId =R.string.walkingTours ,
                imageResourceId = R.drawable.todo4,
                subtitleResourceId = R.string.walkingTours1,

            ),ToDo(
                id = 5,
                titleResourceId =R.string.winterSports ,
                imageResourceId = R.drawable.todo5,
                subtitleResourceId = R.string.winterSports1,

            )



        )
    }
}
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
                subtitleResourceId2 =  R.string.busTour2,
                subtitleResourceId3 = R.string.busTour3,
                subtitleResourceId4 = R.string.busTour4,
                subtitleResourceId5 = R.string.busTour5,


           ),

            ToDo(
                id = 2,
                titleResourceId =R.string.dayTrips ,
                imageResourceId = R.drawable.todo2,
                        subtitleResourceId = R.string.dayTrips1,
                subtitleResourceId2 =  R.string.dayTrips2,
                subtitleResourceId3 = R.string.dayTrips3,
                subtitleResourceId4 =  R.string.dayTrips4,
                subtitleResourceId5 = R.string.dayTrips5,

        ),
            ToDo(
                id = 3,
                titleResourceId =R.string.cityTour ,
                imageResourceId = R.drawable.todo3,

                subtitleResourceId = R.string.cityTour1,
                subtitleResourceId2 =  R.string.cityTour2,
                subtitleResourceId3 = R.string.cityTour3,
                subtitleResourceId4 =  R.string.cityTour4,
                subtitleResourceId5 = R.string.cityTour5,

            ),

            ToDo(
                id = 4,
                titleResourceId =R.string.walkingTours ,
                imageResourceId = R.drawable.todo4,
                subtitleResourceId = R.string.walkingTours1,
                subtitleResourceId2 =  R.string.walkingTours2,
                subtitleResourceId3 = R.string.walkingTours3,
                subtitleResourceId4 =  R.string.walkingTours4,
                subtitleResourceId5 = R.string.walkingTours5,

            ),ToDo(
                id = 5,
                titleResourceId =R.string.winterSports ,
                imageResourceId = R.drawable.todo5,
                subtitleResourceId = R.string.winterSports1,
                subtitleResourceId2 =  R.string.winterSports2,
                subtitleResourceId3 = R.string.winterSports3,
                subtitleResourceId4 =  R.string.winterSports4,
                subtitleResourceId5 = R.string.winterSports5,

            )



        )
    }
}
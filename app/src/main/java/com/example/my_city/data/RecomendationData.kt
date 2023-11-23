package com.example.my_city.data

import com.example.my_city.R
import com.example.my_city.model.Recomendation
import com.example.my_city.model.ToDo

object RecomendationData{
    val defaultRecomendation = getRecomendationData()[0]

    fun getRecomendationData(): List<Recomendation> {
        return listOf(
            Recomendation(
                rid = 1,
                rtitleResourceId =R.string.busTour1 ,
                rimageResourceId = R.drawable.bus1
            ),
            Recomendation(
                rid =2,
                rtitleResourceId =R.string.busTour2 ,
                rimageResourceId = R.drawable.bus2
            ),
            Recomendation(
                rid = 3,
                rtitleResourceId =R.string.busTour3 ,
                rimageResourceId = R.drawable.bus3
            ),
            Recomendation(
                rid = 4,
                rtitleResourceId =R.string.busTour4 ,
                rimageResourceId = R.drawable.bus4
            ),
            Recomendation(
                rid = 5,
                rtitleResourceId =R.string.busTour5 ,
                rimageResourceId = R.drawable.bus5
            ),



        )
    }
}
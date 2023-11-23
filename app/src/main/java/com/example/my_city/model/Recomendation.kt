package com.example.my_city.model


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recomendation(
    val rid: Int,
    @StringRes val rtitleResourceId:  Int,
    @DrawableRes val rimageResourceId: Int
)

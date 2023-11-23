package com.example.my_city.model




import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ToDo(
    val id: Int,
    @StringRes val titleResourceId:  Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val recomend1: Int,
    @StringRes val recomend2: Int,
    @StringRes val recomend3: Int,
    @StringRes val recomend4: Int,
    @StringRes val recomend5: Int,
)

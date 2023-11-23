package com.example.my_city.model




import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ToDo(
    val id: Int,
    @StringRes val titleResourceId:  Int,
    @DrawableRes val imageResourceId: Int
)

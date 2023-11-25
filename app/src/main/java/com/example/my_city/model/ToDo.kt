package com.example.my_city.model




import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ToDo(
    val id: Int,
    @StringRes val titleResourceId:  Int,
    @DrawableRes val imageResourceId: Int,

    @StringRes val subtitleResourceId: Int,
    @StringRes val subtitleResourceId2: Int,
    @StringRes val subtitleResourceId3: Int,
    @StringRes val subtitleResourceId4: Int,
    @StringRes val subtitleResourceId5: Int,

)

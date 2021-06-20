package com.raywenderlich.flashscore.models


import androidx.annotation.Keep


@Keep
data class Results(

    val match: Match?,
    val resultCode: Int?
)
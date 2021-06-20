package com.raywenderlich.flashscore.models


import androidx.annotation.Keep

@Keep
data class TeamAction(
    val action: Action?,
    val actionType: Int?,
    val teamType: Int?
)
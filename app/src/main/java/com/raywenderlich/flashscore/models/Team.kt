package com.raywenderlich.flashscore.models



import androidx.annotation.Keep

@Keep
data class Team(
    val ballPosition: Int?,
    val score: Int?,
    val teamImage: String?,
    val teamName: String?
)
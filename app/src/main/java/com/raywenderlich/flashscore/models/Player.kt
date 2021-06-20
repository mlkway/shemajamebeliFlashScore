package com.raywenderlich.flashscore.models



import androidx.annotation.Keep

@Keep
data class Player(
    val playerImage: String?,
    val playerName: String?
)
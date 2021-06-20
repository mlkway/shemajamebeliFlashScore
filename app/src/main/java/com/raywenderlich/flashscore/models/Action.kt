package com.raywenderlich.flashscore.models



import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Action(

    val goalType: Int?,
    @SerializedName("player",alternate = ["player1"])
    val player1: Player?,
    val player2: Player?
)
package com.raywenderlich.flashscore.models



import androidx.annotation.Keep

@Keep
data class Summary(
    val actionTime: String,
    val team1Action: List<TeamAction>,
    val team2Action: List<TeamAction>
)
package com.raywenderlich.flashscore.models



import androidx.annotation.Keep

@Keep
data class Match(
    val matchDate: Long?,
    val matchSummary: MatchSummary?,
    val matchTime: Double?,
    val stadiumAdress: String?,
    val team1: Team?,
    val team2: Team?
)
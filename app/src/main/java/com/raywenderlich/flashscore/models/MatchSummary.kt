package com.raywenderlich.flashscore.models



import androidx.annotation.Keep

@Keep
data class MatchSummary(

    val summaries: List<Summary>
)
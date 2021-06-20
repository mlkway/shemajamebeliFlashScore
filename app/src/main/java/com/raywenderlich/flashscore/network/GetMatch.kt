package com.raywenderlich.flashscore.network

import com.raywenderlich.flashscore.models.Results
import retrofit2.Response
import retrofit2.http.GET

interface   GetMatch {



    @GET("48bb936e-261a-4471-a362-3bbb3b9a2a58")
    suspend fun getMatchData(): Response<Results>

}
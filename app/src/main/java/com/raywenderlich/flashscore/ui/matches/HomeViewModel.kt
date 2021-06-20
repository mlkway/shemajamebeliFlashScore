package com.raywenderlich.flashscore.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.flashscore.models.Match
import com.raywenderlich.flashscore.models.Results
import com.raywenderlich.flashscore.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    private var _data = MutableLiveData<Match>()

    val data: LiveData<Match> get() = _data


    fun load(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO){
                ApiService.apiService.getMatchData().body()

            }
            _data.postValue(data?.match!!)
        }
    }



}
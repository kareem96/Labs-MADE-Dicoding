package com.kareemdev.myreactivesearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.myreactivesearch.network.ApiConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel : ViewModel(){
    private val accessToken = "pk.eyJ1Ijoia2FyZWVtOTYiLCJhIjoiY2wxazd6MTkzMHU5MTNqcnBnbGVtZ2V4byJ9.gEy9H4VYJE3E8JUxmyquDg"
    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    val searchResult = queryChannel.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .filter { it.trim().isNotEmpty() }
        .mapLatest { ApiConfig.provideApiService().getCountry(it, accessToken).features }
        .asLiveData()
}
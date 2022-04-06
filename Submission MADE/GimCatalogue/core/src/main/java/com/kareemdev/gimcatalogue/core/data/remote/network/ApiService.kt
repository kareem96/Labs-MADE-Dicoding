package com.kareemdev.gimcatalogue.core.data.remote.network

import com.kareemdev.gimcatalogue.core.data.remote.response.ListGamesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("games")
    suspend fun getList(): ListGamesResponse
}
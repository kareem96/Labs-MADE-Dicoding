package com.kareemdev.tourismapps.core.data.source.remote.network

import com.kareemdev.tourismapps.core.data.source.remote.response.ListTourismResponse
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list")
//    fun getList(): Call<ListTourismResponse>
    fun getList(): Flowable<ListTourismResponse>
}
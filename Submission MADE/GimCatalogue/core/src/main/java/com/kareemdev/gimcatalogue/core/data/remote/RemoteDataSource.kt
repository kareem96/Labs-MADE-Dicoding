package com.kareemdev.gimcatalogue.core.data.remote

import android.util.Log
import com.kareemdev.gimcatalogue.core.data.remote.network.ApiResponse
import com.kareemdev.gimcatalogue.core.data.remote.network.ApiService
import com.kareemdev.gimcatalogue.core.data.remote.response.GamesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource constructor(private val apiService: ApiService){
    companion object{

    }

    suspend fun getAllGim(): Flow<ApiResponse<List<GamesResponse>>>{
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.results
                if(dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("getAllGim: ", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}
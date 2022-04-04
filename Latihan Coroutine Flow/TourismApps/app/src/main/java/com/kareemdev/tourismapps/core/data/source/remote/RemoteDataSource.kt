package com.kareemdev.tourismapps.core.data.source.remote

import android.annotation.SuppressLint
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kareemdev.tourismapps.core.data.source.remote.network.ApiResponse
import com.kareemdev.tourismapps.core.data.source.remote.response.TourismResponse
import com.kareemdev.tourismapps.core.utils.JsonHelper
import org.json.JSONException
import android.os.Handler
import com.kareemdev.tourismapps.core.data.source.remote.network.ApiService
import com.kareemdev.tourismapps.core.data.source.remote.response.ListTourismResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

//class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

//        fun getInstance(helper: JsonHelper): RemoteDataSource =
        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    /*fun getAllTourism(): Flowable<ApiResponse<List<TourismResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<TourismResponse>>>()*/
    suspend fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> {
//        val resultData = PublishSubject.create<ApiResponse<List<TourismResponse>>>()
        //get data from network
        /*val client = apiService.getList()*/
        /*client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.places
                resultData.onNext(if(dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
            })
        return resultData.toFlowable(BackpressureStrategy.BUFFER)*/

        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places
                if(dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.places))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource: ", e.toString() )
            }
        }.flowOn(Dispatchers.IO)

    }
}

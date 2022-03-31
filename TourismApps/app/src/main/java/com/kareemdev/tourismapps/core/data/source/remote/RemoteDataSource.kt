package com.kareemdev.tourismapps.core.data.source.remote

import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kareemdev.tourismapps.core.data.source.remote.network.ApiResponse
import com.kareemdev.tourismapps.core.data.source.remote.response.TourismResponse
import com.kareemdev.tourismapps.core.utils.JsonHelper
import org.json.JSONException
import android.os.Handler

class RemoteDataSource(private val jsonHelper:JsonHelper){
    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this){
            instance ?: RemoteDataSource(helper)
        }
    }

    fun getAllTourism(): LiveData<ApiResponse<List<TourismResponse>>>{
        val resultData = MutableLiveData<ApiResponse<List<TourismResponse>>>()

        //
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            try {
                val dataArray = jsonHelper.loadData()
                if(dataArray.isNotEmpty()){
                    resultData.value = ApiResponse.Success(dataArray)
                }else{
                    resultData.value = ApiResponse.Empty
                }
            }catch (e: JSONException){
                resultData.value = ApiResponse.Error(e.toString())
                Log.e("getAllTourism: ",e.toString() )
            }
        }, 2000)
        return resultData
    }
}
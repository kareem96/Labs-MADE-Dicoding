package com.kareemdev.tourismapps.core.data

import androidx.lifecycle.LiveData
import com.kareemdev.tourismapps.core.data.source.local.LocalDataSource
import com.kareemdev.tourismapps.core.data.source.local.entity.TourismEntity
import com.kareemdev.tourismapps.core.data.source.remote.RemoteDataSource
import com.kareemdev.tourismapps.core.data.source.remote.network.ApiResponse
import com.kareemdev.tourismapps.core.data.source.remote.response.TourismResponse
import com.kareemdev.tourismapps.core.utils.AppExecutors
import com.kareemdev.tourismapps.core.utils.DataMapper

class TourismRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors

) {

    companion object {
        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors):TourismRepository = instance ?: synchronized(this){
            instance ?: TourismRepository(remoteData, localData, appExecutors)
        }
    }


    fun getAllTourism(): LiveData<Resource<List<TourismEntity>>> =
        object : NetworkBoundResource<List<TourismEntity>, List<TourismResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TourismEntity>> {
                return localDataSource.getAllTourism()
            }

            override fun shouldFetch(data: List<TourismEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TourismResponse>>> {
                return remoteDataSource.getAllTourism()
            }

            override fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asLiveData()

    fun getFavoriteTourism(): LiveData<List<TourismEntity>>{
        return localDataSource.getFavorite()
    }

    fun setFavoriteTourism(tourism: TourismEntity, state: Boolean){
        appExecutors.diskIO().execute{
            localDataSource.setFavoriteTourism(tourism, state)
        }
    }
}
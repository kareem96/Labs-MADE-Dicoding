package com.kareemdev.tourismapps.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kareemdev.tourismapps.core.data.source.local.LocalDataSource
import com.kareemdev.tourismapps.core.data.source.remote.RemoteDataSource
import com.kareemdev.tourismapps.core.data.source.remote.network.ApiResponse
import com.kareemdev.tourismapps.core.data.source.remote.response.TourismResponse
import com.kareemdev.tourismapps.core.domain.model.Tourism
import com.kareemdev.tourismapps.core.domain.repository.ITourismRepository
import com.kareemdev.tourismapps.core.utils.AppExecutors
import com.kareemdev.tourismapps.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TourismRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository{

    /*companion object {
        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepository =
            instance ?: synchronized(this) {
                instance ?: TourismRepository(remoteData, localData, appExecutors)
            }
    }*/

    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }

            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {

        return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute{localDataSource.setFavoriteTourism(tourismEntity, state)}
    }
}
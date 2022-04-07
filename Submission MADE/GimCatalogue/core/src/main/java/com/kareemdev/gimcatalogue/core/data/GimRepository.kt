package com.kareemdev.gimcatalogue.core.data

import com.kareemdev.gimcatalogue.core.data.local.LocalDataSource
import com.kareemdev.gimcatalogue.core.data.remote.RemoteDataSource
import com.kareemdev.gimcatalogue.core.data.remote.network.ApiResponse
import com.kareemdev.gimcatalogue.core.data.remote.response.GamesResponse
import com.kareemdev.gimcatalogue.core.domain.model.Gim
import com.kareemdev.gimcatalogue.core.domain.repository.IGimRepository
import com.kareemdev.gimcatalogue.core.utils.AppExecutors
import com.kareemdev.gimcatalogue.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GimRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
): IGimRepository {
    override fun getAllGim(): Flow<Resource<List<Gim>>> =
        object : NetworkBoundResource<List<Gim>, List<GamesResponse>>(){
            override suspend fun saveCallResult(data: List<GamesResponse>) {
                val gimList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertGim(gimList)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponse>>> =
                remoteDataSource.getAllGim()

            override fun shouldFetch(data: List<Gim>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDB(): Flow<List<Gim>> {
                return localDataSource.getAllGim().map { DataMapper.mapEntitiesToDomain(it) }
            }

        }.asFlow()


    override fun getFavoriteGim(): Flow<List<Gim>> {
        return localDataSource.getFavoriteGim().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteGIm(gim: Gim, state: Boolean) {
        val gimEntity = DataMapper.mapDomainToEntity(gim)
        appExecutors.diskIO().execute{localDataSource.setFavoriteGim(gimEntity, state)}
    }
}
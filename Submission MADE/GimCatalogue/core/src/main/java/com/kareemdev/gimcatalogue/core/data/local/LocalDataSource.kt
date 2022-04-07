package com.kareemdev.gimcatalogue.core.data.local

import com.kareemdev.gimcatalogue.core.data.local.entity.GimEntity
import com.kareemdev.gimcatalogue.core.data.local.room.GimDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource constructor(private val gimDao: GimDao) {

    fun getAllGim(): Flow<List<GimEntity>> = gimDao.getAllGim()

    fun getFavoriteGim(): Flow<List<GimEntity>> = gimDao.getFavoriteGim()

    fun setFavoriteGim(gim: GimEntity, newState: Boolean){
        gim.isFavorite = newState
        gimDao.updateFavoriteGim(gim)
    }
    suspend fun insertGim(gimList: List<GimEntity>) = gimDao.insertGim(gimList)
}
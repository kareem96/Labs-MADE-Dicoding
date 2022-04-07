package com.kareemdev.gimcatalogue.core.data.local.room

import androidx.room.*
import com.kareemdev.gimcatalogue.core.data.local.entity.GimEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GimDao {

    @Query("SELECT * FROM gim")
    fun getAllGim(): Flow<List<GimEntity>>

    @Query("SELECT * FROM gim where isFavorite = 1")
    fun getFavoriteGim(): Flow<List<GimEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGim(gim: List<GimEntity>)

    @Update
    fun updateFavoriteGim(gim: GimEntity)
}
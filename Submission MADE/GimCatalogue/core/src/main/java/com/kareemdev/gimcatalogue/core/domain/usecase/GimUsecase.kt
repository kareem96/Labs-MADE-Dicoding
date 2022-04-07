package com.kareemdev.gimcatalogue.core.domain.usecase


import com.kareemdev.gimcatalogue.core.data.Resource
import com.kareemdev.gimcatalogue.core.domain.model.Gim
import kotlinx.coroutines.flow.Flow

interface GimUseCase {
    fun getAllGim():  Flow<Resource<List<Gim>>>
    fun getFavoriteGim(): Flow<List<Gim>>
    fun setFavoriteGim(gim: Gim, state: Boolean)
}
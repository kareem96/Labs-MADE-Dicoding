package com.kareemdev.gimcatalogue.core.domain.repository

import com.kareemdev.gimcatalogue.core.data.Resource
import com.kareemdev.gimcatalogue.core.domain.model.Gim
import kotlinx.coroutines.flow.Flow

interface IGimRepository {
    fun getAllGim(): Flow<Resource<List<Gim>>>
    fun getFavoriteGim(): Flow<List<Gim>>
    fun setFavoriteGIm(gim: Gim, state:Boolean)
}
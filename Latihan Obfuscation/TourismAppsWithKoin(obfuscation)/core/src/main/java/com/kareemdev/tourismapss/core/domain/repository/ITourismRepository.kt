package com.kareemdev.tourismapss.core.domain.repository

import com.kareemdev.tourismapss.core.data.Resource
import com.kareemdev.tourismapss.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}
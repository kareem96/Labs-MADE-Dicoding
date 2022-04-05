package com.kareemdev.tourismapps.core.domain.usecase

import com.kareemdev.tourismapps.core.data.Resource
import com.kareemdev.tourismapps.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}
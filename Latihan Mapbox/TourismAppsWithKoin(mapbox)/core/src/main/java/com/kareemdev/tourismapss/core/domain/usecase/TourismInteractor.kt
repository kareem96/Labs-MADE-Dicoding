package com.kareemdev.tourismapss.core.domain.usecase

import com.kareemdev.tourismapss.core.data.Resource
import com.kareemdev.tourismapss.core.domain.model.Tourism
import com.kareemdev.tourismapss.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }

}
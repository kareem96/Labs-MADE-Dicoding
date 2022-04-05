package com.kareemdev.tourismapps.core.domain.usecase

import androidx.lifecycle.LiveData
import com.kareemdev.tourismapps.core.data.Resource
import com.kareemdev.tourismapps.core.domain.model.Tourism
import com.kareemdev.tourismapps.core.domain.repository.ITourismRepository
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TourismInteractor @Inject constructor (private val tourismRepository: ITourismRepository): TourismUseCase {
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
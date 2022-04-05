package com.kareemdev.tourismapps.detail

import androidx.lifecycle.ViewModel
import com.kareemdev.tourismapps.core.data.TourismRepository
import com.kareemdev.tourismapps.core.data.source.local.entity.TourismEntity
import com.kareemdev.tourismapps.core.domain.model.Tourism
import com.kareemdev.tourismapps.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class DetailTourismViewModel @Inject constructor(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}
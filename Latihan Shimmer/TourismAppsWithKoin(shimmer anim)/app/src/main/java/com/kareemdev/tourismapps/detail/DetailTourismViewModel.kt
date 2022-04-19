package com.kareemdev.tourismapps.detail

import androidx.lifecycle.ViewModel
import com.kareemdev.tourismapss.core.domain.model.Tourism
import com.kareemdev.tourismapss.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}
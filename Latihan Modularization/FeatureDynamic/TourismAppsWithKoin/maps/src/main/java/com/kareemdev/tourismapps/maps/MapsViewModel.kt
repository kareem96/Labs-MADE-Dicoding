package com.kareemdev.tourismapps.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.tourismapss.core.domain.usecase.TourismUseCase

class MapsViewModel(tourismUseCase: TourismUseCase) : ViewModel(){
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}
package com.kareemdev.tourismapps.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.tourismapps.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
//    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())

}

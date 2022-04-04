package com.kareemdev.tourismapps.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.kareemdev.tourismapps.core.data.TourismRepository
import com.kareemdev.tourismapps.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
//    val tourism = tourismUseCase.getAllTourism()
    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())
}

package com.kareemdev.tourismapps.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.tourismapps.core.data.TourismRepository
import com.kareemdev.tourismapps.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor (tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
//    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())

}

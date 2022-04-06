package com.kareemdev.tourismapps.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.tourismapss.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
    /*val favoriteTourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getFavoriteTourism())*/

}
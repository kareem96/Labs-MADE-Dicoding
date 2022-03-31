package com.kareemdev.tourismapps.favorite

import androidx.lifecycle.ViewModel
import com.kareemdev.tourismapps.core.data.TourismRepository

class FavoriteViewModel(tourismRepository: TourismRepository) : ViewModel(){
    val favoriteTourism = tourismRepository.getFavoriteTourism()
}
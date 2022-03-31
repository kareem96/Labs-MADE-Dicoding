package com.kareemdev.tourismapps.home

import androidx.lifecycle.ViewModel
import com.kareemdev.tourismapps.core.data.TourismRepository

class HomeViewModel(tourismRepository: TourismRepository) : ViewModel() {
    val tourism = tourismRepository.getAllTourism()
}
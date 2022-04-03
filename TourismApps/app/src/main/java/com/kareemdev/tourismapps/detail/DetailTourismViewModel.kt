package com.kareemdev.tourismapps.detail

import androidx.lifecycle.ViewModel
import com.kareemdev.tourismapps.core.data.TourismRepository
import com.kareemdev.tourismapps.core.data.source.local.entity.TourismEntity

class DetailTourismViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun setFavoriteTourism(tourism: TourismEntity, newStatus:Boolean) = tourismRepository.setFavoriteTourism(tourism, newStatus)
}
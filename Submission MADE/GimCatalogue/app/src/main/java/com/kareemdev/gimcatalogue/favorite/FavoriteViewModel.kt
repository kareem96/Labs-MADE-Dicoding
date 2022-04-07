package com.kareemdev.gimcatalogue.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.gimcatalogue.core.domain.usecase.GimUseCase

class FavoriteViewModel(gimUseCase: GimUseCase): ViewModel() {
    val favoriteGim = gimUseCase.getFavoriteGim().asLiveData()
}
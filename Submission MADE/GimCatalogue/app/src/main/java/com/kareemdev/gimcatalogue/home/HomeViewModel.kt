package com.kareemdev.gimcatalogue.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.gimcatalogue.core.domain.usecase.GimUseCase

class HomeViewModel(gimUseCase: GimUseCase) : ViewModel(){
    val gim = gimUseCase.getAllGim().asLiveData()
}
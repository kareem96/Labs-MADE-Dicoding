package com.kareemdev.tmdbapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kareemdev.tmdbapp.core.domain.usecase.MovieUseCase

class HomeViewModel (movieUseCase: MovieUseCase): ViewModel(){
    val movie = movieUseCase.getAllMovie().asLiveData()
}
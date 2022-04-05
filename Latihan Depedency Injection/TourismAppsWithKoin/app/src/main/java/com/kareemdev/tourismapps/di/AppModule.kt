package com.kareemdev.tourismapps.di

import androidx.lifecycle.ViewModel
import com.kareemdev.tourismapps.core.domain.usecase.TourismInteractor
import com.kareemdev.tourismapps.core.domain.usecase.TourismUseCase
import com.kareemdev.tourismapps.detail.DetailTourismViewModel
import com.kareemdev.tourismapps.favorite.FavoriteViewModel
import com.kareemdev.tourismapps.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get(), ) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}
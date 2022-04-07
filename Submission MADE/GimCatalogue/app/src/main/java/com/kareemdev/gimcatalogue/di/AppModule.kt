package com.kareemdev.gimcatalogue.di

import com.kareemdev.gimcatalogue.core.domain.usecase.GimInteractor
import com.kareemdev.gimcatalogue.core.domain.usecase.GimUseCase
import com.kareemdev.gimcatalogue.favorite.FavoriteViewModel
import com.kareemdev.gimcatalogue.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GimUseCase> {GimInteractor(get())}
}

val viewModelModule = module {
    viewModel{HomeViewModel(get())}
    viewModel { FavoriteViewModel(get()) }
}
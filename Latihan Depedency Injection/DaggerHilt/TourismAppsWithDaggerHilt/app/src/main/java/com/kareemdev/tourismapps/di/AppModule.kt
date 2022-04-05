package com.kareemdev.tourismapps.di

import com.kareemdev.tourismapps.core.domain.usecase.TourismInteractor
import com.kareemdev.tourismapps.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module


@Module
abstract class AppModule {
    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}
package com.kareemdev.tourismapps.core.di

import com.kareemdev.tourismapps.core.data.TourismRepository
import com.kareemdev.tourismapps.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module


@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository
}
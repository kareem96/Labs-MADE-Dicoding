package com.kareemdev.tourismapps.core.di

import android.content.Context
import com.kareemdev.tourismapps.core.data.TourismRepository
import com.kareemdev.tourismapps.core.data.source.local.LocalDataSource
import com.kareemdev.tourismapps.core.data.source.local.room.TourismDatabase
import com.kareemdev.tourismapps.core.data.source.remote.RemoteDataSource
import com.kareemdev.tourismapps.core.utils.AppExecutors
import com.kareemdev.tourismapps.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): TourismRepository{
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
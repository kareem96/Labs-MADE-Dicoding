package com.kareemdev.gimcatalogue.core.di

import androidx.room.Room
import com.kareemdev.gimcatalogue.core.data.GimRepository
import com.kareemdev.gimcatalogue.core.data.local.LocalDataSource
import com.kareemdev.gimcatalogue.core.data.local.room.GimDatabase
import com.kareemdev.gimcatalogue.core.data.remote.RemoteDataSource
import com.kareemdev.gimcatalogue.core.domain.repository.IGimRepository
import com.kareemdev.gimcatalogue.core.utils.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    factory { get<GimDatabase>().gimDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            GimDatabase::class.java, "Gim.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {

}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IGimRepository> { GimRepository(get(), get(), get()) }
}
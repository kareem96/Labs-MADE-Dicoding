package com.kareemdev.tourismapps

import android.app.Application
import com.kareemdev.tourismapss.core.di.databaseModule
import com.kareemdev.tourismapss.core.di.networkModule
import com.kareemdev.tourismapss.core.di.repositoryModule
import com.kareemdev.tourismapps.di.useCaseModule
import com.kareemdev.tourismapps.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}
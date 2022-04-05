package com.kareemdev.tourismapps

import android.app.Application
import com.kareemdev.tourismapps.core.di.CoreComponent
import com.kareemdev.tourismapps.core.di.DaggerCoreComponent
import com.kareemdev.tourismapps.di.AppComponent
import com.kareemdev.tourismapps.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}
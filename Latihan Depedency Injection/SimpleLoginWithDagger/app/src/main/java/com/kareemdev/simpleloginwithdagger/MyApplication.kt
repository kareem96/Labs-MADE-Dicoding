package com.kareemdev.simpleloginwithdagger

import android.app.Application
import com.kareemdev.simpleloginwithdagger.di.AppComponent
import com.kareemdev.simpleloginwithdagger.di.DaggerAppComponent

open class MyApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }
}
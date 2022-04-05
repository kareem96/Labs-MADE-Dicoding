package com.kareemdev.tourismapps

import android.app.Application
/*import com.kareemdev.tourismapps.core.di.CoreComponent
import com.kareemdev.tourismapps.core.di.DaggerCoreComponent
import com.kareemdev.tourismapps.di.AppComponent
import com.kareemdev.tourismapps.di.DaggerAppComponent*/
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class MyApplication : Application()
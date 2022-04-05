package com.kareemdev.simpleloginwithdagger.di

import android.content.Context
import com.kareemdev.simpleloginwithdagger.HomeActivity
import com.kareemdev.simpleloginwithdagger.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
}
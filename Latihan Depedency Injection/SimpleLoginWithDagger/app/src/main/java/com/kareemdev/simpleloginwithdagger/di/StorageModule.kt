package com.kareemdev.simpleloginwithdagger.di

import android.content.Context
import com.kareemdev.simpleloginwithdagger.SessionManager
import dagger.Module
import dagger.Provides


@Module
class StorageModule {
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}
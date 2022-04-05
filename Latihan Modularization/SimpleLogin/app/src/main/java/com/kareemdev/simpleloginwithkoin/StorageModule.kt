package com.kareemdev.simpleloginwithkoin

import com.kareemdev.core.SessionManager
import com.kareemdev.core.UserRepository
import org.koin.dsl.module

val storageModule = module{
    factory {
        SessionManager(get())
    }

    single {
        UserRepository(get())
    }
}

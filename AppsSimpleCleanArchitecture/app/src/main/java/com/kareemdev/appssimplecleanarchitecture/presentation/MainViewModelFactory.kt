package com.kareemdev.appssimplecleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kareemdev.appssimplecleanarchitecture.di.Injection
import com.kareemdev.appssimplecleanarchitecture.domain.MessageUseCase
import java.lang.IllegalArgumentException

class MainViewModelFactory(private var messageUseCase: MessageUseCase): ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(): MainViewModelFactory = instance ?: synchronized(this){
            instance ?: MainViewModelFactory(Injection.providerUseCase())
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(messageUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
package com.kareemdev.appssimplecleanarchitecture.di

import com.kareemdev.appssimplecleanarchitecture.data.IMessageDataSource
import com.kareemdev.appssimplecleanarchitecture.data.MessageDataSource
import com.kareemdev.appssimplecleanarchitecture.data.MessageRepository
import com.kareemdev.appssimplecleanarchitecture.domain.IMessageRepository
import com.kareemdev.appssimplecleanarchitecture.domain.MessageInteractor
import com.kareemdev.appssimplecleanarchitecture.domain.MessageUseCase

object Injection {
    fun providerUseCase(): MessageUseCase{
        val messageRepository = providerRepository()
        return MessageInteractor(messageRepository)
    }

    private fun providerRepository(): IMessageRepository{
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource{
        return MessageDataSource()
    }
}
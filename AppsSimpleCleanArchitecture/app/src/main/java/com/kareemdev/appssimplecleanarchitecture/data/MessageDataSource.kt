package com.kareemdev.appssimplecleanarchitecture.data

import com.kareemdev.appssimplecleanarchitecture.domain.MessageEntity

class MessageDataSource : IMessageDataSource{
    override fun getMessageFromSource(name: String): MessageEntity {
        return MessageEntity("Hello $name! Welcome to Clean Architecture")
    }
}
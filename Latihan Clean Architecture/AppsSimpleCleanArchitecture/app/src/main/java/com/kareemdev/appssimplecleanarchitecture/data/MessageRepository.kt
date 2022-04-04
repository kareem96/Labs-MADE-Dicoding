package com.kareemdev.appssimplecleanarchitecture.data

import com.kareemdev.appssimplecleanarchitecture.domain.IMessageRepository
import com.kareemdev.appssimplecleanarchitecture.domain.MessageEntity

class MessageRepository(private val messageDataSource: IMessageDataSource): IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity {
        return messageDataSource.getMessageFromSource(name)
    }

}
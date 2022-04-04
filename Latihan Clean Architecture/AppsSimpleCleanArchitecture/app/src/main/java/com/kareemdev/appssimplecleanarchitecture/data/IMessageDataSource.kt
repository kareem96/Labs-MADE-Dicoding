package com.kareemdev.appssimplecleanarchitecture.data

import com.kareemdev.appssimplecleanarchitecture.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name:String): MessageEntity
}
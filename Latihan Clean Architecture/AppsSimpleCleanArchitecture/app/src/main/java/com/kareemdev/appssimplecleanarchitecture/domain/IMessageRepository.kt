package com.kareemdev.appssimplecleanarchitecture.domain

interface IMessageRepository {
    fun getWelcomeMessage(name:String): MessageEntity
}
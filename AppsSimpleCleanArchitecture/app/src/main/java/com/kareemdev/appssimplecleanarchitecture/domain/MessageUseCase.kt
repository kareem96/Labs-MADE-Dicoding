package com.kareemdev.appssimplecleanarchitecture.domain

interface MessageUseCase {
    fun getMessage(name:String): MessageEntity
}
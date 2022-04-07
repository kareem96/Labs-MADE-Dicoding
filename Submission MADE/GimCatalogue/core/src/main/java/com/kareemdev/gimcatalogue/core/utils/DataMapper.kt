package com.kareemdev.gimcatalogue.core.utils

import com.kareemdev.gimcatalogue.core.data.local.entity.GimEntity
import com.kareemdev.gimcatalogue.core.data.remote.response.GamesResponse
import com.kareemdev.gimcatalogue.core.domain.model.Gim

object DataMapper {
    fun mapResponseToEntities(input: List<GamesResponse>): List<GimEntity>{
        val gimList = ArrayList<GimEntity>()
        input.map {
            val gim = GimEntity(
                gimId = it.id,
                name = it.name,
                background_image = it.background_image,
                rating = it.rating,
                isFavorite = false,
            )
            gimList.add(gim)
        }
        return gimList
    }
    fun mapEntitiesToDomain(input: List<GimEntity>): List<Gim> =
        input.map {
            Gim(
                gimId = it.gimId,
                name = it.name,
                background_image = it.background_image,
                rating = it.rating,
                isFavorite = it.isFavorite,
            )
        }

    fun mapDomainToEntity(input: Gim) = GimEntity(
        gimId = input.gimId,
        name = input.name,
        background_image = input.background_image,
        rating = input.rating,
        isFavorite = input.isFavorite,
    )

}
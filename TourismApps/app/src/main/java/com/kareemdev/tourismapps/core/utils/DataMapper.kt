package com.kareemdev.tourismapps.core.utils

import com.kareemdev.tourismapps.core.data.source.local.entity.TourismEntity
import com.kareemdev.tourismapps.core.data.source.remote.response.TourismResponse

object DataMapper {
    fun mapResponseToEntities(input: List<TourismResponse>): List<TourismEntity>{
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism = TourismEntity(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }
}
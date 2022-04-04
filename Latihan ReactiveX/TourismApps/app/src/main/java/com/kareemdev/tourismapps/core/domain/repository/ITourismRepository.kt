package com.kareemdev.tourismapps.core.domain.repository

import androidx.lifecycle.LiveData
import com.kareemdev.tourismapps.core.data.Resource
import com.kareemdev.tourismapps.core.domain.model.Tourism
import io.reactivex.Flowable

interface ITourismRepository {
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}
package com.kareemdev.tourismapps.core.domain.repository

import androidx.lifecycle.LiveData
import com.kareemdev.tourismapps.core.data.Resource
import com.kareemdev.tourismapps.core.domain.model.Tourism

interface ITourismRepository {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}
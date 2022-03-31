package com.kareemdev.tourismapps.core.data

import com.kareemdev.tourismapps.core.data.source.remote.RemoteDataSource

class TourismRepository private constructor(
    private val remoteDataSource: RemoteDataSource
){
    
}
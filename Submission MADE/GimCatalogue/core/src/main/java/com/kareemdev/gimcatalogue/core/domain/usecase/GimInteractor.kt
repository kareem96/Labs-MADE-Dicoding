package com.kareemdev.gimcatalogue.core.domain.usecase

import com.kareemdev.gimcatalogue.core.data.Resource
import com.kareemdev.gimcatalogue.core.domain.model.Gim
import com.kareemdev.gimcatalogue.core.domain.repository.IGimRepository
import kotlinx.coroutines.flow.Flow

class GimInteractor (private val gimRepository: IGimRepository): GimUseCase{
    override fun getAllGim(): Flow<Resource<List<Gim>>> {
        return gimRepository.getAllGim()
    }

    override fun getFavoriteGim(): Flow<List<Gim>> {
        return gimRepository.getFavoriteGim()
    }

    override fun setFavoriteGim(gim: Gim, state: Boolean) {
        return gimRepository.setFavoriteGIm(gim, state)
    }

}
package com.kareemdev.gimcatalogue.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @field:SerializedName("id")
    val id: Int
)

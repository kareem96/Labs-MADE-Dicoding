package com.kareemdev.gimcatalogue.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("background_image")
    val background_image: Int,
    @field:SerializedName("rating")
    val rating: Double,
)

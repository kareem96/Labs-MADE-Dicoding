package com.kareemdev.gimcatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gim(
    var gimId: Int,
    var name: String,
    val background_image: Int,
    val rating: Double,
    var isFavorite: Boolean = false
): Parcelable
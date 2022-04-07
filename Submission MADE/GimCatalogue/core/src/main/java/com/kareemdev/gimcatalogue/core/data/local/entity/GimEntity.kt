package com.kareemdev.gimcatalogue.core.data.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "gim")
data class GimEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "gimId")
    var gimId: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name ="background_image")
    val background_image: Int,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name="isFavorite")
    var isFavorite: Boolean = false
): Parcelable
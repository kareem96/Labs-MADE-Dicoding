package com.kareemdev.gimcatalogue.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kareemdev.gimcatalogue.core.data.local.entity.GimEntity

@Database(entities = [GimEntity::class], version = 1, exportSchema = false)
abstract class GimDatabase : RoomDatabase(){
    abstract fun gimDao(): GimDao

    companion object{
        @Volatile
        private var INSTANCE: GimDatabase? = null
    }
}
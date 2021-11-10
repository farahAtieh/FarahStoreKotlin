package com.example.farahstorekotlin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.farahstorekotlin.data.db.dao.StoreDao
import com.example.farahstorekotlin.data.db.entity.StoreItemEntity

@Database(entities = [StoreItemEntity::class], version = 1, exportSchema = false)
abstract class StoreDatabase: RoomDatabase() {

    abstract fun storeDao(): StoreDao


}
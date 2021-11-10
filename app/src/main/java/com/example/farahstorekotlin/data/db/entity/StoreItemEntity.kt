package com.example.farahstorekotlin.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.farahstorekotlin.data.db.DatabaseInfo

@Entity(tableName = DatabaseInfo.TableName.TABLE_FAV_ITEMS)
data class StoreItemEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title")
    var itemName: String,
    @ColumnInfo(name = "price")
    var itemPrice: Double,
    @ColumnInfo(name = "image")
    var imageUrl: String,
)
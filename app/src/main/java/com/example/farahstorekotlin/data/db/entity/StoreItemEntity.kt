package com.example.farahstorekotlin.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "fav_table")
data class StoreItemEntity(
    @ColumnInfo(name ="id")
    @PrimaryKey
    var id: Int = 0,
    @ColumnInfo(name ="name")
    var itemName: String = "",
    @ColumnInfo(name ="price")
    var itemPrice: Double = 0.0,
    @ColumnInfo(name ="imageUrl")
    var imageUrl: String = ""
) {

}
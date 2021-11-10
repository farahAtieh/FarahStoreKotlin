package com.example.farahstorekotlin.data.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import io.reactivex.rxjava3.core.Flowable

abstract class StoreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertItem(item: StoreItemEntity)

    @Query("delete from fav_table where id =:id")
    abstract fun deleteItem(id: Int)

    @Query("select * from fav_table")
    abstract fun getFavProducts(): Flowable<List<StoreItemEntity>>
}
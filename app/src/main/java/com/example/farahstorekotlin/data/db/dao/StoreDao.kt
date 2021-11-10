package com.example.farahstorekotlin.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.farahstorekotlin.data.db.DatabaseInfo
import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import io.reactivex.rxjava3.core.Flowable

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItem(storeItemEntity: StoreItemEntity)

    @Query("delete from " + DatabaseInfo.TableName.TABLE_FAV_ITEMS +" where id =:itemId")
    fun deleteItem(itemId: Int)

    @Query("Select * from " + DatabaseInfo.TableName.TABLE_FAV_ITEMS)
    fun getFavItems(): Flowable<List<StoreItemEntity>>

}
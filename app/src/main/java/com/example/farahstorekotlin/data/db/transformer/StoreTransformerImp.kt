package com.example.farahstorekotlin.data.db.transformer

import com.example.farahstorekotlin.data.db.dao.StoreDao
import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import com.example.farahstorekotlin.data.model.StoreItem
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class StoreTransformerImp @Inject constructor(private val storeDao: StoreDao): StoreTransformer {

    override fun addItemToFav(storeItem: StoreItem) {
        storeDao.insertItem(storeItem.mapToStoreItemEntity())
    }

    override fun deleteItemFromFav(id: Int) {
        storeDao.deleteItem(id)
    }

    override fun getFavItems(): Flowable<List<StoreItem>> {
        return storeDao.getFavItems()
            .subscribeOn(Schedulers.computation())
            .map {
                it.map { storeItemEntity -> storeItemEntity.mapToStoreItem() }
            }
    }

    fun StoreItem.mapToStoreItemEntity(): StoreItemEntity =
        StoreItemEntity(id, itemName, itemPrice, imageUrl)

    fun StoreItemEntity.mapToStoreItem(): StoreItem =
        StoreItem(id, itemName, itemPrice, imageUrl)
}
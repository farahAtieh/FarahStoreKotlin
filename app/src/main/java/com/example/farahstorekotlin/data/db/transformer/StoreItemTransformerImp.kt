package com.example.farahstorekotlin.data.db.transformer

import com.example.farahstorekotlin.data.db.dao.StoreDao
import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import com.example.farahstorekotlin.data.model.StoreItem
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class StoreItemTransformerImp @Inject constructor(
    private val storeDao: StoreDao
): StoreItemTransformer{

    override fun addItemToFav(storeItem: StoreItem) {
        storeDao.insertItem(storeItem.mapToStoreItemEntity())
    }

    override fun deleteItemFromFav(id: Int) {
        storeDao.deleteItem(id)
    }

    override fun getFavProducts(): Flowable<List<StoreItem>> {
        return storeDao.getFavProducts()
            .subscribeOn(Schedulers.computation())
            .map {
                it.map { storeItemEntity -> storeItemEntity.mapToStoreItemModel() }
            }
    }

    private fun StoreItem.mapToStoreItemEntity() = StoreItemEntity(
        id = id,
        itemName = itemName,
        itemPrice = itemPrice,
        imageUrl = imageUrl
    )

    private fun StoreItemEntity.mapToStoreItemModel() = StoreItem(
        id = id,
        itemName = itemName,
        itemPrice = itemPrice,
        imageUrl = imageUrl
    )

}
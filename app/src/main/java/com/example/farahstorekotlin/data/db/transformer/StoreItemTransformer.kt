package com.example.farahstorekotlin.data.db.transformer

import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import com.example.farahstorekotlin.data.model.StoreItem
import io.reactivex.rxjava3.core.Flowable

interface StoreItemTransformer {

    fun addItemToFav(storeItem: StoreItem)

    fun deleteItemFromFav(id: Int)

    fun getFavProducts(): Flowable<List<StoreItem>>
}
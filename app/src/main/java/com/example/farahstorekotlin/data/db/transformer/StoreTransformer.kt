package com.example.farahstorekotlin.data.db.transformer

import com.example.farahstorekotlin.data.model.StoreItem
import io.reactivex.rxjava3.core.Flowable

interface StoreTransformer {

    fun addItemToFav(storeItem:StoreItem)

    fun deleteItemFromFav(id: Int)

    fun getFavItems(): Flowable<List<StoreItem>>
}
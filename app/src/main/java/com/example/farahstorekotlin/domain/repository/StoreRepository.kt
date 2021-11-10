package com.example.farahstorekotlin.domain.repository

import com.example.farahstorekotlin.data.db.entity.StoreItemEntity
import com.example.farahstorekotlin.data.model.StoreItem
import io.reactivex.rxjava3.core.Flowable

interface StoreRepository {

    fun getStoresItem(): Flowable<List<StoreItem>>

    fun addItemToFav(storeItem: StoreItem)

    fun deleteItemFromFav(id: Int)

    fun getFavProducts(): Flowable<List<StoreItem>>
}